package com.aqh.reply.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 댓글DTO
 * 
 * @author Devesg
 * @since 23.01.11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

	private long bno; // 게시글 번호
	private long rno; // 댓글 번호 (AI)
	private Integer prno; // 부모 댓글 번호
	private String writeDay; // 게시글 작성일
	private String id;
	private String contents;

}