package com.aqh.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aqh.common.domain.dto.AttachFileDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Devesg
 * @since 23.01.18
 */
@Slf4j
@Controller
public class UploadController {

	@GetMapping(value = "/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}

	@ResponseBody
	@PostMapping(value = "/uploadAjaxAction", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<AttachFileDTO>> uploadAjax(MultipartFile[] files) {

		List<AttachFileDTO> list = new ArrayList<>();

		String uploadFolder = "C:\\upload";
		String uploadFolderPath = getFolder();
		// make folder
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		System.out.println(">>>>>>>>>" + uploadPath);
		if (!uploadPath.exists()) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : files) {
			AttachFileDTO attachFileDTO = new AttachFileDTO();

			String uploadFileName = multipartFile.getOriginalFilename();
			UUID uuid = UUID.randomUUID();

			// IE has file Path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			attachFileDTO.setFileName(uploadFileName);
			uploadFileName = uuid.toString() + "_" + uploadFileName;

			attachFileDTO.setUuid(uuid.toString());
			attachFileDTO.setUploadPath(uploadFolderPath);
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				if (checkImageType(saveFile)) {
					attachFileDTO.setImage(true);
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			list.add(attachFileDTO);
		}
		System.out.println("1111111");
		// communityService.createPost(boardDTO);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


    @GetMapping(value="/download",
    produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<Resource> downloadFile(String fileName) {
        FileSystemResource resource = new FileSystemResource("C\\upload\\"+fileName);
        log.info("resource" + resource);
        String resourceName = resource.getFilename();
        HttpHeaders header = new HttpHeaders();
            try {
                header.add("Content-Disposition", "attachment; filename="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                // 여기 하고있었음!!!!!!!!! 532페이지
            }
        return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
    }
    

	@ResponseBody
	@GetMapping(value = "/display")
	public ResponseEntity<byte[]> getFile(String fileName) {
		File file = new File("c:\\upload\\" + fileName);
		System.out.println("file >>>>>>>>" + file);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd");
		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
