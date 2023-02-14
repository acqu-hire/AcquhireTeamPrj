package com.aqh.file.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.aqh.file.domain.FileDTO;
import com.aqh.file.service.FileService;
import com.google.gson.JsonObject;

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

	@PostMapping("/fileUpload")
	public void fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {

		JsonObject json = new JsonObject();
		OutputStream out = null;
		PrintWriter printWriter = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		if (upload != null) {
			if (upload.getSize() > 0 && StringUtils.isNotBlank(upload.getName())) {
				try {
					String extension = fileService.getExtension(upload.getOriginalFilename());
					if (!fileService.isAllowedExtension(extension)) {
						json.addProperty("responseError", "허용되지 않는 확장자 또는 파일입니다.");
					} else {
						String fileName = UUID.randomUUID().toString() + extension;
						Path uploadPath = Paths.get(request.getServletContext().getRealPath("/resources/image/"))
								.toAbsolutePath();
						Files.createDirectories(uploadPath);
						Path filePath = uploadPath.resolve(fileName);
						Files.write(filePath, upload.getBytes());
	
						printWriter = response.getWriter();
						String fileUrl = request.getContextPath() + "/resources/image/" + fileName;
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						printWriter.print(json);
					}
				} catch (IOException | IllegalArgumentException e) {
					json.addProperty("error", e.getMessage());
					printWriter.print(json);
				} finally {
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (printWriter != null) {
						printWriter.close();
					}
				}

			}
		}
	}
}
