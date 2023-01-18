package com.aqh.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aqh.common.domain.dto.FileNoticeDTO;



public class FileControllerNotice {
	/*public List<FileNoticeDTO> fileInfo(int seq, HttpServletRequest request, MultipartHttpServletRequest mhsr) throws Exception, IOException{
		if(ObjectUtils.isEmpty(mhsr)) {
			return null;
		}
		List<FileNoticeDTO> fileList = new ArrayList<FileNoticeDTO>();
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";
		
		File file = new File(root_path+attach_path);
		if(file.exists()==false) {
			file.mkdir(); //디렉토리 생성 메소드
		}
		
		Iterator<String> iterator = mhsr.getFileNames();
		while(iterator.hasNext()) {
			List<MultipartFile> list = mhsr.getFiles(iterator.next());
			for (MultipartFile multipartFile : list) {
				FileNoticeDTO fileNoticeDTO = new FileNoticeDTO();
				fileNoticeDTO.setSeq(seq);
				fileNoticeDTO.setFileSize(multipartFile.getSize());
				fileNoticeDTO.setFilePath(root_path+attach_path);
				fileNoticeDTO.setOriginalFileName(multipartFile.getOriginalFilename());
				fileList.add(fileNoticeDTO);
				
				file = new File(root_path+attach_path+multipartFile.getOriginalFilename());
				multipartFile.transferTo(file); //???
			}
		}
		
		return fileList;
		
	}*/

}
