package com.aqh.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.reply.domain.ReplyCriteria;
import com.aqh.reply.domain.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String namespace = "com.aqh.reply.dao.ReplyMapper.";

	@Override
	public int register(ReplyDTO replyDTO) {
		return sqlSessionTemplate.insert(namespace + "register", replyDTO);
	}

	@Override
	public List<ReplyDTO> getReplyList(ReplyCriteria cri) {
		return sqlSessionTemplate.selectList(namespace + "getReplyList", cri);
	}

	@Override
	public ReplyDTO getReply(long rno) {
		return sqlSessionTemplate.selectOne(namespace+"getReply", rno);
	}

	@Override
	public int modify(ReplyDTO replyDTO) {
		return sqlSessionTemplate.update(namespace + "modifyReply", replyDTO);
	}

	@Override
	public int removeReply(long rno) {
		return sqlSessionTemplate.delete(namespace + "removeReply", rno);
	}
	
	@Override
	public int replyCntUpdate(long bno) {
		return sqlSessionTemplate.update(namespace + "replyCntUpdate", bno);
	}
	
	@Override
	public int getNestedReplyList(long rno) {
		return sqlSessionTemplate.selectOne(namespace + "getNestedReplyList", rno);
	}
}