package com.aqh.common.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.common.domain.dto.AttachFile;

@Repository
public class FileDAO {

	@Autowired
	SqlSessionTemplate session;
	
	String namespace = "com.aqh.common.domain.dao.fileMapper.";
	
	public int upload(AttachFile attach) {
		return session.insert(namespace + "upload", attach);
	}

	public List<AttachFile> getFileName(long bNo) {
		return session.selectList(namespace + "getFileName", bNo);
	}
	
}
