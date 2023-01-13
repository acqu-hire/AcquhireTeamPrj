package com.aqh.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.common.domain.dao.FileDAO;
import com.aqh.common.domain.dto.AttachFile;

@Service
public class FileService {

	@Autowired
	FileDAO fileDAO;
	
	public int upload(AttachFile attach) {
		return fileDAO.upload(attach);
	}
	
	public List<AttachFile> getFileName(long bNo) {
		return fileDAO.getFileName(bNo);
	}
}
