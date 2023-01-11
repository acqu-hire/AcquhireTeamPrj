package com.aqh.reply.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 댓글DTO
 * @author Devesg
 * @since 23.01.11
 */
@Getter
@Setter
public class ReplyDTO {
    
    private long bNo;   // 게시글 번호 
    private long rNo;   // 댓글 번호 (AI)
    private String writeDay; // 게시글 작성일
    private String id;
    private String contents;

}
