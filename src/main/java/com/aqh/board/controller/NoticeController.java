package com.aqh.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.CriteriaNotice;
import com.aqh.board.domain.pagehandler.PaginationNotice;
import com.aqh.board.service.NoticeService;
import com.aqh.common.controller.FileControllerNotice;
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
	public String noticeSelectDetail(Model model, Integer bNo) {
		noticeService.noticeReadCount(bNo);
		model.addAttribute("selectDetail", noticeService.selectDetail(bNo));
		
		List<FileNoticeDTO> fileNoticeDTOs = noticeService.fileUpList(bNo);
		int end = 0;
		for (int i = 0; i < fileNoticeDTOs.size(); i++) {
			end = i;
		}
		model.addAttribute("fileNoList", fileNoticeDTOs);
		model.addAttribute("end", end);

		log.info("게시판 내용 보기" + model);
		
		return "board/notice/noticeListDetail";
	}
	
	@GetMapping(value = "/fileDown")
	public String fileDown(@RequestParam(value = "fileUuid", required = true) String fileUuid, @RequestParam(value = "fileName", required = true) String fileName, HttpServletResponse response) throws Throwable {
		fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
		response.setContentType("application/octet-stream");
		String savePlace = "C:\\test\\upload\\final/";
		File file = new File(savePlace);
		if(file.exists()==false) {
			file.mkdir(); //디렉토리 생성 메소드
		}
		
		return "C:\\test\\upload\\final\\"+fileName;
	}
	
	@GetMapping(value = "/insert_view")
	public String insertView() {
		return "board/notice/noticeInsert";
	}
	
	
	@PostMapping(value = "/insert")	
	public String insert(Model model, BoardDTO boardDTO, HttpServletRequest request, MultipartHttpServletRequest mhsr) throws Exception {	
			
			Category selectCategory;
			if (boardDTO.getCategory().toString().equals("NOTICE_NOTICE"))
				selectCategory = Category.NOTICE_NOTICE;
			else
				selectCategory = Category.NOTICE_EVENT;
			
			boardDTO.setCategory(selectCategory);
			noticeService.insert(boardDTO);


			List<FileNoticeDTO> fileNoList = new ArrayList<FileNoticeDTO>();
			
			String root_path = request.getSession().getServletContext().getRealPath("./resources/upload");
			String attach_path = "\\";

			
			File file = new File(root_path+attach_path);
			if(file.exists()==false) {
				file.mkdir(); //디렉토리 생성 메소드
			}
			
			UUID uuid = UUID.randomUUID();
            log.info("랜덤아이디"+uuid.toString());
            String[] uuids = uuid.toString().split("-");
            String uniqueName = uuids[0];
			
			Iterator<String> iterator = mhsr.getFileNames();
			while(iterator.hasNext()) {
				List<MultipartFile> list = mhsr.getFiles(iterator.next());
				for (MultipartFile multipartFile : list) {
					FileNoticeDTO fileNoticeDTO = new FileNoticeDTO();
					fileNoticeDTO.setBNo(boardDTO.getbNo());
					fileNoticeDTO.setUuid(uniqueName);
					fileNoticeDTO.setFile_size(multipartFile.getSize());
					fileNoticeDTO.setFile_path(root_path+attach_path);
					fileNoticeDTO.setOriginal_file_name(multipartFile.getOriginalFilename());
					fileNoList.add(fileNoticeDTO);
					
					file = new File(root_path+attach_path+multipartFile.getOriginalFilename());
					multipartFile.transferTo(file);//???해석하기
				}
			}
			
			noticeService.FileInsert(fileNoList);
			log.info("파일내용확인"+fileNoList);
			

		return "redirect:/notice/select_all_view";
	}
	
	
	@GetMapping(value = "/update_view")
	public String updateView(Model model,Integer bNo) {
		model.addAttribute("boardDTO", noticeService.selectDetail(bNo));
		return "board/notice/noticeUpdate";
	}
	
	@PostMapping(value = "/update")	
	public String update(Model model, BoardDTO boardDTO) {
		
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
		
		return "redirect:/notice/select_all_view";
	}
	
	@GetMapping(value = "/delete")
	public String delete(Model model,Integer bNo) {
		noticeService.delete(bNo);

		return "redirect:/notice/select_all_view";
	}
	

}
