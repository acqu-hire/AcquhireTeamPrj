package com.aqh.reply.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.aqh.reply.domain.dto.ReplyDTO;
import com.aqh.reply.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

/**
 * 댓글Service
 * 
 * @author Devesg
 * @since 23.01.11
 */
@Service
@RequiredArgsConstructor
public class ReplyServiceImpI implements ReplyService {

    private final ReplyMapper mapper;

    @Override
    public int register(ReplyDTO replyDTO) {
        return 0;
    }

    @Override
    public List<ReplyDTO> getReplyList(long bNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReplyDTO getReply(Long rno) {
        return mapper.getReply(rno);

    }

    @Override
    public int modify(ReplyDTO replyDTO) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int removeReply(long rno) {
        // TODO Auto-generated method stub
        return 0;
    }

}
