package com.aqh.file.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.file.domain.FileDTO;

@Repository
public class FileDAO {

	@Autowired
	SqlSessionTemplate session;

	String namespace = "com.aqh.file.dao.FileMapper.";

	public int upload(List<FileDTO> files) {
		return session.insert(namespace + "upload", files);
	}

	public int delete(long[] fno) {
		return session.delete(namespace + "delete", fno);
	}

	public List<FileDTO> getFileList(long[] fno) {
		return session.selectList(namespace + "fileList", fno);
	}

	public FileDTO getFileDetail(long fno) {
		return session.selectOne(namespace + "fileDetail", fno);
	}

	public void deleteAll(long bno) {
		session.delete(namespace + "deleteAll", bno);
	}

}
