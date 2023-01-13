package com.aqh.board.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class FileUpDownDTO {
	private String fileName;
}
