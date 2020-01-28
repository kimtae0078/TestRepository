package com.takim.solr.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.takim.solr.service.BoardService;
import com.takim.solr.util.SolrProcessor;
import com.takim.solr.vo.BoardVO;

@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	private SolrProcessor solrProcessor = new SolrProcessor();
	
	//메인 화면(리스트) selectAll
	@SuppressWarnings("static-access")
	@RequestMapping("/")
	public String selectList(BoardVO vo, Model model) throws SolrServerException, IOException {
		Object list = solrProcessor.selectAll(vo);
		model.addAttribute("list", list);
		return "solrBoard/solrBoard";
	}
	
	//검색
	@RequestMapping("/boardSearch")
	public String boardSearch(@ModelAttribute BoardVO vo, Model model) throws SolrServerException, IOException {
		String keyword = vo.getKeyword();
		String option = vo.getOption();
		if (!keyword.equals("") || !keyword.isEmpty()) {
			Object list = solrProcessor.selectSearchAll(keyword, option);
			model.addAttribute("keyword", keyword);
			model.addAttribute("option", option);
			model.addAttribute("list", list);
		} else {
			Object list = solrProcessor.selectAll(vo);
			model.addAttribute("list", list);
		}
		return "solrBoard/solrBoard";
	}
	
	//글 등록 페이지 이동
	@RequestMapping("/solrRegistView")
	public String solrRegistView(){
		return "solrBoard/solrRegist";
	}
	
	//글 등록
	@RequestMapping(name = "solrRegist", method = RequestMethod.POST)
	public String solrRegist(@ModelAttribute BoardVO vo) throws SolrServerException, IOException {
		boardService.solrRegist(vo);
		return "redirect:/";
	}
	
	//글 수정 페이지 이동
	@SuppressWarnings("static-access")
	@RequestMapping("/solrUpdateView")
	public String solrUpdateView(@ModelAttribute BoardVO vo, Model model) throws SolrServerException, IOException {
		Object resultVO = solrProcessor.solrUpdateView(vo);
		model.addAttribute("view", resultVO);
		return "solrBoard/solrUpdateView";
	}
	
	//글 수정
	@RequestMapping("/solrUpdate")
	public String solrUpdate(@ModelAttribute BoardVO vo) throws SolrServerException, IOException {
		System.out.println(vo.toString()+"tostring vo");
		boardService.solrUpdate(vo);
		return "redirect:/";
	}
	
	//글 삭제
	@RequestMapping("/solrDelete")
	public String solrDelete(@ModelAttribute BoardVO vo) throws SolrServerException, IOException {
		boardService.solrDelete(vo);
		return "redirect:/";
	}
	
	
	
}
