package com.takim.controller;

import java.util.List;

import javax.security.auth.login.CredentialNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.takim.model.CrudVO;
import com.takim.service.CrudService;

@Controller
public class CrudController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrudController.class);

	
	//service
	@Autowired
	private CrudService crudService;
	
	//리스트 호출
	@RequestMapping("/")
	public String selectList(CrudVO vo, Model model){
		logger.info("list...");
		List<CrudVO> selectList = null;
		selectList = crudService.selectList();
		model.addAttribute("list", selectList);
		return "jpaBoard/jpaBoard";
	}
	
	//글 등록 페이지 이동
	@RequestMapping("/jpaRegistView")
	public String jpaRegistView(){
		return "jpaBoard/jpaRegist";
	}
	
	//글 등록
	@RequestMapping("/jpaRegist")
	public String jpaRegist(CrudVO vo) {
		crudService.jpaRegist(vo);
		return "redirect:/;";
	}
	
	//글 수정 페이지 이동
	@RequestMapping("/jpaUpdateView")
	public String jpaUpdateView(CrudVO vo, Model model) {
		logger.info("view Get...");
		CrudVO resultVO = crudService.jpaView(vo);
		model.addAttribute("view", resultVO);
		return "jpaBoard/jpaUpdate";
	}

	//글 수정
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public String jpaUpdate(@ModelAttribute CrudVO vo) {
		logger.info("수정....");
		crudService.jpaUpdate(vo);
		return "redirect:/";
	}
	
	// 글 삭제
	@RequestMapping("/jpaDelete")
	public String view(CrudVO vo, Model model){
		crudService.jpaDelete(vo);
		return "redirect:/";
	}

	
		
}
