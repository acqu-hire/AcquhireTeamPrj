package com.aqh.common.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.common.domain.dao.FileDAO;
import com.aqh.common.domain.dto.AttachFile;
import com.aqh.common.domain.dto.FileDTO;

@Service
public class FileService {

	FileDAO fileDao;
	AttachFile attach;
	
	public FileService(FileDAO fileDao, AttachFile attach) {
		this.fileDao = fileDao;
		this.attach = attach;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int upload(HttpServletRequest request, BoardDTO boardDTO) {
		int result = 0;
		String uploadPath = request.getServletContext().getRealPath("resources") + "\\upload\\";
		while(boardDTO.getFiles().remove(null)) {}
		if(!(boardDTO.getFiles().get(0).getOriginalFilename().equals("")) && boardDTO.getFiles() != null) {
			boardDTO.setFileList(attach.getFileAttach(uploadPath, boardDTO));
			result = fileDao.upload(boardDTO.getFileList());
		}
			return result;
	}
	
	public List<FileDTO> getFileList(long[] fNo) {
		return fileDao.getFileList(fNo);
	}

	public int delete(FileDTO fileDTO, BoardDTO boardDTO) {
		int result = 0;
		if(fileDTO.getDelAttach()!=null) {
			boardDTO.setFileList(fileDao.getFileList(fileDTO.getDelAttach()));
			attach.removeFile(fileDTO, boardDTO);
		result = fileDao.delete(fileDTO.getDelAttach());
		}
		return result;
	}
	
	public FileDTO getFileDetail(long fNo) {
		return fileDao.getFileDetail(fNo);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteAll(FileDTO fileDTO, BoardDTO boardDTO) {
		delete(fileDTO, boardDTO);
		fileDao.deleteAll(fileDTO.getbNo());
		
	}
}
