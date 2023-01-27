package com.aqh.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;

/**
 * 댓글DAO
 * 
 * @author Devesg
 * @since 23.01.11
 */
@Repository
public class ReplyDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String namespace = "com.aqh.reply.domain.dao.ReplyDAO.";

	public int register(ReplyDTO replyDTO) {
		return sqlSessionTemplate.insert(namespace + "register", replyDTO);
	}

	public List<ReplyDTO> getReplyList(ReplyCriteria cri) {
		return sqlSessionTemplate.selectList(namespace + "getReplyList", cri);
	}

	public ReplyDTO getReply(long rno) {
		return sqlSessionTemplate.selectOne(namespace + "getReply", rno);
	}

	public int modify(ReplyDTO replyDTO) {
		return sqlSessionTemplate.update(namespace + "modifyReply", replyDTO);
	}

	public int removeReply(long rno) {
		return sqlSessionTemplate.delete(namespace + "removeReply", rno);
	}
}
