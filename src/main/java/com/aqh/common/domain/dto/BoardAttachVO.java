package com.aqh.common.domain.dto;

import lombok.Data;


/**
 * @author Devesg
 * @since 23.01.19
 * @see also
 * 파일을 Board DTO에 전달 시켜줄 VO
 */
@Data
public class BoardAttachVO {
   private String uuid;
   private String uploadpath;
   private String fileName;
   private boolean fileType;

   private Long bno;
}
