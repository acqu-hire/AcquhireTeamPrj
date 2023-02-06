package com.aqh.file.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FileNoticeDTO {

	private long bno;
	private String uuid;
	private int f_seq;
	private String original_file_name;
	private String file_path;
	private long file_size;

}
