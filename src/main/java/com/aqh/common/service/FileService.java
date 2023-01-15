package com.aqh.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Service;

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
	
	public int upload(HttpServletRequest request, BoardDTO boardDTO) {
		String uploadPath = request.getServletContext().getRealPath("resources") + "\\upload\\";
		if(boardDTO.getFiles()!=null) {
			boardDTO.setFileList(attach.getFileAttach(uploadPath, boardDTO));
			return fileDao.upload(boardDTO.getFileList());
		} else {
			return 0;
		}
	}
	
	public List<FileDTO> getFileList(long bNo) {
		return fileDao.getFileList(bNo);
	}
	
}
