package com.aqh.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.CriteriaNotice;
import com.aqh.board.domain.pagehandler.PaginationNotice;
import com.aqh.board.service.NoticeService;
import com.aqh.common.domain.dto.FileNoticeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	

	@Autowired
	private NoticeService noticeService;


	@GetMapping(value = "/select_all_view")
	public String menuSelectAll(Model model, CriteriaNotice criteriaNotice) {
		
		
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll(criteriaNotice));
		model.addAttribute("PaginationNotice", new PaginationNotice( criteriaNotice, (int) noticeService.BoardListAllCount(criteriaNotice)));
		log.info("전체조회 카운트"+noticeService.BoardListAllCount(criteriaNotice));
		log.info("전체조회"+model);


		return "board/notice/noticeList";
	}

	@GetMapping(value = "/select_category_view")
	public String categorySelectAll(Model model, CriteriaNotice criteriaNotice) {
		
		model.addAttribute("categorySelectAll", noticeService.categorySelectAll(criteriaNotice));
		model.addAttribute("PaginationNotice", new PaginationNotice(criteriaNotice, (int) noticeService.CategoryListCount(criteriaNotice)));
		
		return "board/notice/noticeCategoryList";
	}


	@GetMapping(value = "/select_Detail_view")
	public String noticeSelectDetail(Model model, Integer bno) {
		noticeService.noticeReadCount(bno);
		model.addAttribute("selectDetail", noticeService.selectDetail(bno));
		
		List<FileNoticeDTO> fileNoticeDTOs = noticeService.fileUpList(bno);
		model.addAttribute("fileNoList", fileNoticeDTOs);

		log.info("게시판 내용 보기" + model);
		
		return "board/notice/noticeListDetail";
	}
	
	@GetMapping(value = "/fileDownLoad")
	@ResponseBody
	public ResponseEntity<Resource> fileDownLoad(@RequestParam("fileName") String fileName, @RequestParam("bno") Integer bno ,HttpServletRequest request){
		
		String path = request.getSession().getServletContext().getRealPath("/") + "/resources/upload/";
		Resource resource = new FileSystemResource(path + fileName);
		String resourceName = resource.getFilename();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("UTF-8"),	"ISO-8859-1"));
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
	
	@GetMapping(value = "/insert_view")
	public String insertView() {
		return "board/notice/noticeInsert";
	}
	
	
	@PostMapping(value = "/insert")	
	public String insert(Model model, BoardDTO boardDTO, HttpServletRequest request, MultipartHttpServletRequest mhsr) throws Exception, IOException  {	
			
			Category selectCategory;
			if (boardDTO.getCategory().toString().equals("NOTICE_NOTICE"))
				selectCategory = Category.NOTICE_NOTICE;
			else
				selectCategory = Category.NOTICE_EVENT;
			
			boardDTO.setCategory(selectCategory);
			noticeService.insert(boardDTO);

			//파일업로드
			List<FileNoticeDTO> fileNoList = new ArrayList<FileNoticeDTO>();
			
			String root_path = request.getSession().getServletContext().getRealPath("./resources/upload");
			String attach_path = "\\";

			
			File file = new File(root_path+attach_path);
			if(file.exists()==false) {
				file.mkdir(); //디렉토리 생성 메소드
			}
			
			Iterator<String> iterator = mhsr.getFileNames();
			while(iterator.hasNext()) {
				List<MultipartFile> list = mhsr.getFiles(iterator.next());
				for (MultipartFile multipartFile : list) {
					
					UUID uuid = UUID.randomUUID();
		            log.info("랜덤아이디"+uuid.toString());
		            String[] uuids = uuid.toString().split("-");
		            String uniqueName = uuids[0];
		            
					FileNoticeDTO fileNoticeDTO = new FileNoticeDTO();
					fileNoticeDTO.setBno(boardDTO.getBno());
					fileNoticeDTO.setUuid(uniqueName);
					fileNoticeDTO.setFile_size(multipartFile.getSize());
					fileNoticeDTO.setFile_path(root_path+attach_path);
					fileNoticeDTO.setOriginal_file_name(multipartFile.getOriginalFilename());
					fileNoList.add(fileNoticeDTO);
					
					file = new File(root_path+attach_path+uniqueName+"_"+multipartFile.getOriginalFilename()); // [./resources/upload//파일명_uuid]
					multipartFile.transferTo(file);
				}
			}
			
			noticeService.fileInsert(fileNoList);
			log.info("파일내용확인"+fileNoList);
			

		return "redirect:/notice/select_all_view";
	}
	
	
	@GetMapping(value = "/update_view")
	public String updateView(Model model,Integer bno) {
		model.addAttribute("boardDTO", noticeService.selectDetail(bno));
		List<FileNoticeDTO> fileNoticeDTOs = noticeService.fileUpList(bno);
		model.addAttribute("fileNoList", fileNoticeDTOs);
		return "board/notice/noticeUpdate";
	}
	

	@PostMapping(value = "/update")
	public String update(Model model, BoardDTO boardDTO, HttpServletRequest request, MultipartHttpServletRequest mhsr, String uuid) throws Exception, IOException {

		log.info("글 수정 1차 확인" + boardDTO);
		Category selectCategory;
		if (boardDTO.getCategory().toString().equals("NOTICE_NOTICE"))
			selectCategory = Category.NOTICE_NOTICE;
		else
			selectCategory = Category.NOTICE_EVENT;
		log.info("글 수정 2차 확인" + boardDTO);
		boardDTO.setCategory(selectCategory);
		log.info("글 수정 정보" + boardDTO);
		noticeService.update(boardDTO);
		
		
		//파일업로드
		List<FileNoticeDTO> fileNoList = new ArrayList<FileNoticeDTO>();
		
		String root_path = request.getSession().getServletContext().getRealPath("./resources/upload");
		String attach_path = "\\";

		
		File file = new File(root_path+attach_path);
		if(file.exists()==false) {
			file.mkdir(); //디렉토리 생성 메소드
		}
		
		Iterator<String> iterator = mhsr.getFileNames();
		while(iterator.hasNext()) {
			List<MultipartFile> list = mhsr.getFiles(iterator.next());
			for (MultipartFile multipartFile : list) {
				
				UUID updateUuid = UUID.randomUUID();
	            log.info("랜덤아이디"+updateUuid.toString());
	            String[] uuids = updateUuid.toString().split("-");
	            String uniqueName = uuids[0];
	            
				FileNoticeDTO fileNoticeDTO = new FileNoticeDTO();
				fileNoticeDTO.setBno(boardDTO.getBno());
				fileNoticeDTO.setUuid(uniqueName);
				fileNoticeDTO.setFile_size(multipartFile.getSize());
				fileNoticeDTO.setFile_path(root_path+attach_path);
				fileNoticeDTO.setOriginal_file_name(multipartFile.getOriginalFilename());
				fileNoList.add(fileNoticeDTO);
				
				file = new File(root_path+attach_path+uniqueName+"_"+multipartFile.getOriginalFilename()); // [./resources/upload//파일명_uuid]
				multipartFile.transferTo(file);
			}
		}
		

		log.info("uuid확인"+uuid);
		//uuid="6d86a747";
		noticeService.fileInsert(fileNoList);
		noticeService.fileSelectDelete(uuid);
		return "redirect:/notice/select_all_view";
	}
	
	@GetMapping(value = "/delete")
	public String delete(Model model,Integer bno) {
		noticeService.delete(bno);
		noticeService.fileDeleteAll(bno);

		return "redirect:/notice/select_all_view";
	}
	

}
