package com.aqh.board.controller;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
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
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.NoticeService;
import com.aqh.common.domain.FileNoticeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	

	@Autowired
	private NoticeService noticeService;


	@GetMapping(value = "/select_all_view")
	public String menuSelectAll(Model model, Criteria criteria) {
		
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll(criteria));
		model.addAttribute("Pagination", new Pagination((int) noticeService.BoardListAllCount(criteria), criteria ));
		log.info("전체조회 카운트"+noticeService.BoardListAllCount(criteria));
		log.info("전체조회"+model);

		return "board/notice/noticeList";
	}

	@GetMapping(value = "/select_category_view")
	public String categorySelectAll(Model model, Criteria criteria) {
		
		model.addAttribute("categorySelectAll", noticeService.categorySelectAll(criteria));
		model.addAttribute("Pagination", new Pagination((int) noticeService.CategoryListCount(criteria), criteria));
		log.info("카테고리 확인"+ criteria.getCategory());
		
		return "board/notice/noticeCategoryList";
	}


	@GetMapping(value = "/select_Detail_view")
	public String noticeSelectDetail(Model model, Integer bno, Criteria criteria) {
		noticeService.noticeReadCount(bno);
		model.addAttribute("selectDetail", noticeService.selectDetail(bno));
		
		List<FileNoticeDTO> fileNoticeDTOs = noticeService.fileUpList(bno);
		model.addAttribute("fileNoList", fileNoticeDTOs);
		
		//게시판 조회 후 해당 페이지로 넘어가기
		model.addAttribute("criteria", criteria);
		
		return "board/notice/noticeListDetail";
	}
	
	@GetMapping(value = "/fileDownLoad")
	@ResponseBody
	public ResponseEntity<Resource> fileDownLoad(@RequestParam("fileName") String fileName, @RequestParam("bno") Integer bno ,HttpServletRequest request){
		log.info("파일이름확인"+fileName);
		log.info("파일번호확인"+bno);
		String path = request.getSession().getServletContext().getRealPath("\\") + "\\resources\\upload\\";
		log.info("파일경로확인"+path);
		Resource resource = new FileSystemResource(path + fileName);
		log.info("파일경로이름확인"+resource);
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
			
			//null일 경우 파일 생성 억제  
			List<MultipartFile> fileList = mhsr.getFiles("uploadFile");
			if(fileList.size() > 0 && !fileList.get(0).getOriginalFilename().equals("")){
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
			}
			

		return "redirect:/notice/select_all_view";
	}
	
	
	@GetMapping(value = "/update_view")
	public String updateView(Model model,Integer bno, Criteria criteria) {
		model.addAttribute("boardDTO", noticeService.selectDetail(bno));
		List<FileNoticeDTO> fileNoticeDTOs = noticeService.fileUpList(bno);
		model.addAttribute("fileNoList", fileNoticeDTOs);
		//게시판 조회 후 해당 페이지로 넘어가기
		model.addAttribute("criteriaNotice", criteria);
		return "board/notice/noticeUpdate";
	}
	

	@PostMapping(value = "/update")
	public String update(Model model, BoardDTO boardDTO, HttpServletRequest request, MultipartHttpServletRequest mhsr,@RequestParam(required = false) String[] uuid) throws Exception, IOException {
		//log.info("uuid길이확인 : "+uuid.length);
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
		//null일 경우 파일 생성 억제
		List<MultipartFile> fileList = mhsr.getFiles("uploadFile");
		if(fileList.size() > 0 && !fileList.get(0).getOriginalFilename().equals("")){
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
			noticeService.fileInsert(fileNoList);	
		}
		
		//파일 삭제
		if(uuid != null) {
			HashMap<String, Object> uuidList = new HashMap<String, Object>();
			uuidList.put("uuid", uuid);
			log.info("map 확인" + uuidList.get(uuid));
			noticeService.fileSelectDelete(uuidList);
		}
		
		return "redirect:/notice/select_all_view";
	}
	
	@GetMapping(value = "/delete")
	public String delete(Model model,Integer bno, Criteria criteria) {
		noticeService.delete(bno);
		noticeService.fileDeleteAll(bno);
		
		//게시판 조회 후 해당 페이지로 넘어가기
		Pagination pagination = new Pagination(0, criteria);
		
		if(criteria.getCategory()==null) {
			return "redirect:/notice/select_all_view" + pagination.getListLink(criteria.getPage());
		}else {
			return "redirect:/notice/select_category_view" + pagination.getListLink(criteria.getPage());
		}
		
	}
	

}
