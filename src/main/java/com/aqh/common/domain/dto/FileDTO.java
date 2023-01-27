package com.aqh.common.domain.dto;

import lombok.Data;

@Data
public class FileDTO {

	private long fno;
	private long[] delAttach;
	private long bno;
	private String uuid;
	private String originName;
	private String uploadPath;
	private long fileSize;
	private String fmtFileSize;
	
	public FileDTO() {}
	
	public FileDTO(long bno, String uuid, String originName,
			String uploadPath, long fileSize, String fmtFileSize) {
		this.bno = bno;
		this.uuid = uuid;
		this.originName = originName;
		this.uploadPath = uploadPath;
		this.fileSize = fileSize;
		this.fmtFileSize = fmtFileSize;
	}
	
}
