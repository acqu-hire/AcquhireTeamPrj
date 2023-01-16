package com.aqh.common.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.common.domain.dto.FileDTO;

@Repository
public class FileDAO {

	@Autowired
	SqlSessionTemplate session;
	
	String namespace = "com.aqh.common.domain.dao.FileMapper.";
	
	public int upload(List<FileDTO> files) {
		return session.insert(namespace + "upload", files);
	}

	public int delete(long[] fNo) {
		return session.delete(namespace + "delete", fNo);
	}

	public List<FileDTO> getFileList(long[] fNo) {
		return session.selectList(namespace + "fileList", fNo);
	}
	
	public FileDTO getFileDetail(long fNo) {
		return session.selectOne(namespace + "fileDetail", fNo);
	}

}
