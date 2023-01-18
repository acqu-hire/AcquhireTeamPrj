package com.aqh.common.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FileNoticeDTO {
	
	private long bNo;
	private String uuid;
	private int f_seq;
	private String original_file_name;
	private String file_path;
	private long file_size;
	


}
