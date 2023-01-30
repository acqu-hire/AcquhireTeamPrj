package com.aqh.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.aqh.common.domain.BoardAttachVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UploadDAO {

	private final String namespace = "com.aqh.common.domain.dao.UploadDAO.";

	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(BoardAttachVO boardAttachVO) {
		return sqlSessionTemplate.insert(namespace + "register", boardAttachVO);
	}
    public List<BoardAttachVO> getAttachList(Long bno){
        return sqlSessionTemplate.selectList(namespace+"getAttachList",bno);
    }

	public int deleteAttach(long bno)
	{
		return sqlSessionTemplate.delete(namespace+"deleteAll",bno);
	}
}
