package com.aqh.reply.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.aqh.reply.domain.dto.ReplyDTO;

import lombok.AllArgsConstructor;

/**
 * 댓글DAO
 * 
 * @author Devesg
 * @since 23.01.11
 */
@Repository
@AllArgsConstructor
public class ReplyDAO {

	private final SqlSessionTemplate sqlSessionTemplate;

	public int register(ReplyDTO replyDTO) {
		return sqlSessionTemplate.insert(null, replyDTO);
	}

	public List<ReplyDTO> getReplyList(long bNo) {
		return sqlSessionTemplate.selectList(null, bNo);
	}

	public ReplyDTO getReply(Long rno) {
		return sqlSessionTemplate.selectOne(null,rno);
	}

	public int modify(ReplyDTO replyDTO) {
		return sqlSessionTemplate.update(null, replyDTO);
	}

	public int removeReply(long rno) {
		return sqlSessionTemplate.delete(null,rno);
	}
}
