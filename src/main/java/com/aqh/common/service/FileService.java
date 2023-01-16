package com.aqh.common.service;

import java.io.File;
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
		if(boardDTO.getFiles()!=null) {
			boardDTO.setFileList(attach.getFileAttach(uploadPath, boardDTO));
			result = fileDao.upload(boardDTO.getFileList());
			return result;
		} else {
			return result;
		}
	}
	
	public List<FileDTO> getFileList(long[] fNo) {
		return fileDao.getFileList(fNo);
	}

	@Transactional(rollbackFor = Exception.class)
	public int delete(FileDTO fileDTO, BoardDTO boardDTO) {
		int result = 0;
		if(fileDTO.getDelAttach() != null) {	
			boardDTO.setFileList(fileDao.getFileList(fileDTO.getDelAttach()));
				for(FileDTO file : boardDTO.getFileList()) {
					File delFile = new File(file.getUploadPath() 
										  + file.getUuid() 
										  + attach.getExtension(file.getOriginName()));
					if(delFile.exists()) {
						delFile.delete();
					}
				}
			result = fileDao.delete(fileDTO.getDelAttach());
			return result;
		}
		return result;
	}
	
	public FileDTO getFileDetail(long fNo) {
		return fileDao.getFileDetail(fNo);
	}
}
