package com.aqh.reply.domain.dto;

import java.util.List;

public class ReplyPageDTO {

	private List<ReplyDTO> list;
	private ReplyCriteria cri;
	
	public List<ReplyDTO> getList() {
		return list;
	}
	public void setList(List<ReplyDTO> list) {
		this.list = list;
	}
	public ReplyCriteria getCri() {
		return cri;
	}
	public void setCri(ReplyCriteria cri) {
		this.cri = cri;
	}
	
	@Override
	public String toString() {
		return "ReplyPageDTO [list=" + list + ", cri=" + cri + "]";
	}
	
	
}
