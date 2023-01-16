package com.aqh.common.domain.dto;

import java.util.Arrays;

public class FileDTO {

	private long fNo;
	private long[] delAttach;
	private long bNo;
	private String uuid;
	private String originName;
	private String uploadPath;
	private long fileSize;
	private String fmtFileSize;
	
	public FileDTO() {}
	
	public FileDTO(long bNo, String uuid, String originName,
			String uploadPath, long fileSize, String fmtFileSize) {
		this.bNo = bNo;
		this.uuid = uuid;
		this.originName = originName;
		this.uploadPath = uploadPath;
		this.fileSize = fileSize;
		this.fmtFileSize = fmtFileSize;
	}
	
	public long getfNo() {
		return fNo;
	}

	public void setfNo(long fNo) {
		this.fNo = fNo;
	}
	public long[] getDelAttach() {
		return delAttach;
	}

	public void setDelAttach(long[] delAttach) {
		this.delAttach = delAttach;
	}

	public long getbNo() {
		return bNo;
	}

	public void setbNo(long bNo) {
		this.bNo = bNo;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFmtFileSize() {
		return fmtFileSize;
	}

	public void setFmtFileSize(String fmtFileSize) {
		this.fmtFileSize = fmtFileSize;
	}

	@Override
	public String toString() {
		return "FileDTO [fNo=" + fNo + ", delAttach=" + Arrays.toString(delAttach) + ", bNo=" + bNo + ", uuid=" + uuid
				+ ", originName=" + originName + ", uploadPath=" + uploadPath + ", fileSize=" + fileSize
				+ ", fmtFileSize=" + fmtFileSize + "]";
	}
}
