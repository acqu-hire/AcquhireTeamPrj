package com.aqh.file.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.file.domain.FileDTO;
import com.aqh.file.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

	FileService fileService;

	public FileController(FileService fileService) {
		this.fileService = fileService;
	}

	@GetMapping("/download/{fno}")
	public void download(@PathVariable(name = "fno") long fno, HttpServletResponse response) {
		FileDTO fileDTO = fileService.getFileDetail(fno);
		try {
			String originName = new String(fileDTO.getOriginName().getBytes("utf-8"), "iso-8859-1");
			String extension = fileService.getExtension(originName);
			String filePath = fileDTO.getUploadPath();
			String saveName = fileDTO.getUuid() + extension;

			File file = new File(filePath, saveName);
			if (!file.exists()) {
				throw new FileNotFoundException("경로에 파일이 없습니다.");
			}
			response.setHeader("Content-type", "application/octet-stream;");
			response.setHeader("Content-disposition", "attachment;fileName=\"" + originName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary;");
			response.setHeader("Pragma", "no-cache;");
			response.setHeader("Expries", "-1;");
			FileUtils.copyFile(file, response.getOutputStream());
			response.getOutputStream().close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			response.reset();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
