package com.aqh.common.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AttachFile {

	private long bNo;
	private String uuid;
	private String originName;
	private String uploadPath;
	private long fileSize;
	
	public AttachFile() {}
	
	public AttachFile(long bNo, String uuid, String originName, String uploadPath, long fileSize) {
		this.bNo = bNo;
		this.uuid = uuid;
		this.originName = originName;
		this.uploadPath = uploadPath;
		this.fileSize = fileSize;
	}
}
