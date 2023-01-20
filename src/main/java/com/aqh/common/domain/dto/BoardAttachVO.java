package com.aqh.common.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Data;


/**
 * @author Devesg
 * @since 23.01.19
 * @see also
 * 파일을 Board DTO에 전달 시켜줄 VO
 */
@Data
@Component
public class BoardAttachVO {
   private String fileName;
   private String uuid;
   private String uploadPath;
   private boolean fileType;

   private Long bNo;
}
