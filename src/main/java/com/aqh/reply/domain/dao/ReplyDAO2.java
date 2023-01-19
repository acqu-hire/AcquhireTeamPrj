package com.aqh.reply.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;

@Repository
public class ReplyDAO2 {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String namespace = "com.aqh.reply.domain.dao.ReplyMapper.";

	public int register(ReplyDTO replyDTO) {
		return sqlSessionTemplate.insert(namespace + "register", replyDTO);
	}

	public List<ReplyDTO> getReplyList(ReplyCriteria cri) {
		return sqlSessionTemplate.selectList(namespace + "getReplyList", cri);
	}

	public ReplyDTO getReply(long rno) {
		return sqlSessionTemplate.selectOne(namespace+"getReply", rno);
	}

	public int modify(ReplyDTO replyDTO) {
		return sqlSessionTemplate.update(namespace + "modifyReply", replyDTO);
	}

	public int removeReply(long rno) {
		return sqlSessionTemplate.delete(namespace + "removeReply", rno);
	}
	
	public int replyCntUpdate(long bNo) {
		return sqlSessionTemplate.update(namespace + "replyCntUpdate", bNo);
	}
}
