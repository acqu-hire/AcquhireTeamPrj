package com.aqh.file.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.file.dao.FileDAO;
import com.aqh.file.domain.FileDTO;

@Service
public class FileService {

	private final List<String> allowedExtensions = Arrays.asList(".jpg", ".jpeg", ".png", ".gif");
	
	FileDAO fileDAO;

	public FileService(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

	@Transactional(rollbackFor = Exception.class)
	public void upload(HttpServletRequest request, BoardDTO boardDTO) {

		if (boardDTO.getFiles() == null || boardDTO.getFiles().isEmpty())
			return;

		String uploadPath = request.getServletContext().getRealPath("resources") + "\\upload\\";
		boardDTO.setFiles(boardDTO.getFiles().stream().filter(file -> !file.getOriginalFilename().equals(""))
				.collect(Collectors.toList()));

		boardDTO.setFileList(getFileAttach(uploadPath, boardDTO));
		fileDAO.upload(boardDTO.getFileList());
	}
	
	public List<FileDTO> getFileList(long[] fno) {
		return fileDAO.getFileList(fno);
	}

	public void delete(FileDTO fileDTO) {
		if (fileDTO.getDelAttach() != null) {
			removeFile(fileDAO.getFileList(fileDTO.getDelAttach()));
			fileDAO.delete(fileDTO.getDelAttach());
		}
	}

	public FileDTO getFileDetail(long fno) {
		return fileDAO.getFileDetail(fno);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteAll(FileDTO fileDTO) {
		delete(fileDTO);
		fileDAO.deleteAll(fileDTO.getBno());

	}

	public List<FileDTO> getFileAttach(String uploadPath, BoardDTO boardDTO) {

		File fileDir = new File(uploadPath);

		List<FileDTO> list = new ArrayList<>();

		if (!fileDir.exists())
			fileDir.mkdir();
		for (MultipartFile file : boardDTO.getFiles()) {
			String uuid = getUuid();

			FileDTO fileDTO = new FileDTO(boardDTO.getBno(), uuid, file.getOriginalFilename(), uploadPath,
					file.getSize(), getFmtFileSize(file.getSize()));
			list.add(fileDTO);
			File saveFile = new File(uploadPath + uuid + getExtension(file));
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void removeFile(List<FileDTO> files) {
		for (FileDTO file : files) {
			File delFile = new File(file.getUploadPath() + file.getUuid() + getExtension(file.getOriginName()));
			if (delFile.exists()) {
				delFile.delete();
			}
		}

	}

	private String getFmtFileSize(long fileSize) {
		if (fileSize < 1024) { // 1KB 미만
			return fileSize + "Bytes";
		} else if (fileSize < (1024 * 1024)) { // 1MB 미만
			return Math.round(fileSize / 1024.0) + "KB";
		} else if (fileSize < (1024 * 1024 * 1024)) { // 1GB 미만
			return Math.round(fileSize / (1024.0 * 1024.0)) + "MB";
		} else {
			return Math.round(fileSize / (1024.0 * 1024.0 * 1024.0)) + "GB";
		}
	}

	public String getExtension(String originName) {
		return originName.substring(originName.lastIndexOf(".", originName.length()));
	}

	private String getExtension(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		if (!file.isEmpty()) {
			return fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		return null;
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
	
	public boolean isAllowedExtension(String extension) {
		return allowedExtensions.contains(extension.toLowerCase());
	}
}