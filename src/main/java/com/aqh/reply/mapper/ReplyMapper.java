package com.aqh.reply.mapper;

import java.util.List;

import com.aqh.reply.domain.dto.ReplyDTO;

public interface ReplyMapper {
    // CREATE (생성)
    public int register(ReplyDTO replyDTO);

    // READ (읽기)
    public List<ReplyDTO> getReplyList(long bNo);

    public ReplyDTO getReply(Long rno);

    // UPDATE(수정)
    public int modify(ReplyDTO replyDTO);

    // DELETE (삭제)
    public int removeReply(long rno);
}
