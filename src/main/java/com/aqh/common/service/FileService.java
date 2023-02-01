package com.aqh.common.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.common.dao.FileDAO;
import com.aqh.common.domain.FileDTO;

@Service
public class FileService {

	FileDAO fileDAO;
	
	public FileService(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int upload(HttpServletRequest request, BoardDTO boardDTO) {
		int result = 0;
		String uploadPath = request.getServletContext().getRealPath("resources") + "\\upload\\";
		if(boardDTO.getFiles() != null && !boardDTO.getFiles().isEmpty()) {
			if(!(boardDTO.getFiles().get(0).getOriginalFilename().equals("")) && boardDTO.getFiles() != null) {
				boardDTO.setFileList(getFileAttach(uploadPath, boardDTO));
				result = fileDAO.upload(boardDTO.getFileList());
			}			
		}
			return result;
	}
	
	public List<FileDTO> getFileList(long[] fno) {
		return fileDAO.getFileList(fno);
	}

	public int delete(FileDTO fileDTO, BoardDTO boardDTO) {
		int result = 0;
		if(fileDTO.getDelAttach()!=null) {
			boardDTO.setFileList(fileDAO.getFileList(fileDTO.getDelAttach()));
			removeFile(fileDTO, boardDTO);
		result = fileDAO.delete(fileDTO.getDelAttach());
		}
		return result;
	}
	
	public FileDTO getFileDetail(long fno) {
		return fileDAO.getFileDetail(fno);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteAll(FileDTO fileDTO, BoardDTO boardDTO) {
		delete(fileDTO, boardDTO);
		fileDAO.deleteAll(fileDTO.getBno());
		
	}

	public List<FileDTO> getFileAttach(String uploadPath, BoardDTO boardDTO) {
		File fileDir = new File(uploadPath);
		List<FileDTO> list = new ArrayList<>();
		if(!fileDir.exists()) fileDir.mkdir();
			for(MultipartFile file : boardDTO.getFiles()) {
				if(file.getOriginalFilename() != "") {
					String uuid = getUuid();
					FileDTO fileDTO = new FileDTO(boardDTO.getBno(),
												  uuid,
												  file.getOriginalFilename(),
												  uploadPath,
												  file.getSize(),
												  getFmtFileSize(file.getSize()));
					list.add(fileDTO);
					File saveFile = new File(uploadPath + uuid + getExtension(file));
					try {
						file.transferTo(saveFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					boardDTO.getFiles().remove(file);
				}
			}
		
		return list;
	}
	
	public void removeFile(FileDTO fileDTO, BoardDTO boardDTO) {
		for(FileDTO file : boardDTO.getFileList()) {
			File delFile = new File(file.getUploadPath() 
								  + file.getUuid() 
								  + getExtension(file.getOriginName()));
			if(delFile.exists()) {
				delFile.delete();
			}
		}
		
	}
	
	private String getFmtFileSize(long fileSize) {
		if(fileSize < 1024) { // 1KB 미만
			return fileSize + "Bytes";
		} else if (fileSize < (1024*1024)) { // 1MB 미만
			return Math.round(fileSize/1024.0)+"KB";
		} else if (fileSize < (1024*1024*1024)) { // 1GB 미만
			return Math.round(fileSize/(1024.0*1024.0))+"MB";
		} else {
			return Math.round(fileSize/(1024.0*1024.0*1024.0))+"GB";
		}
	}
	
	public String getExtension(String originName) {
		return originName.substring(originName.lastIndexOf(".", originName.length()));
	}
	
	private String getExtension(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		if(!file.isEmpty()) {
			return fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		return null;
	}
	
	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}