package com.aqh.common.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.aqh.common.domain.dto.BoardAttachVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UploadDAO {

	private final String namespace = "com.aqh.common.domain.dao.UploadDAO.";

	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(BoardAttachVO boardAttachVO) {
		return sqlSessionTemplate.insert(namespace + "register", boardAttachVO);
	}
    public List<BoardAttachVO> getAttachList(Long bNo){
        return sqlSessionTemplate.selectList(namespace+"getAttachList",bNo);
    }

}
