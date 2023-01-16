package com.aqh.reply.service;

import java.util.List;

import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;

/**
 * 댓글Service
 * 
 * @author Devesg
 * @since 23.01.11
 */

public interface ReplyService {

    // CREATE (생성)
    public int register(ReplyDTO replyDTO);

    // READ (읽기)
    public List<ReplyDTO> getReplyList(ReplyCriteria cri);

    public ReplyDTO getReply(Long rno);

    // UPDATE(수정)
    public int modify(ReplyDTO replyDTO);

    // DELETE (삭제)
    public int removeReply(long rno);
}
