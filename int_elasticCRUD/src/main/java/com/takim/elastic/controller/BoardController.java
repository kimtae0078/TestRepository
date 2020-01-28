package com.takim.elastic.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.elasticsearch.ElasticsearchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.takim.elastic.service.BoardService;
import com.takim.elastic.util.ElasticProcessor;
import com.takim.elastic.vo.BoardVO;


@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	private ElasticProcessor elasticProcessor = new ElasticProcessor();
	
	
	//selectAll
	@RequestMapping("/")
	public String selectList(Model model) throws ElasticsearchException, IOException {
		Object list = elasticProcessor.selectAll();
		model.addAttribute("list",list);
		
		return "elasticBoard/elasticBoard";
	}
	
	//insert page
	@RequestMapping("/elasticRegistView")
	public String solrRegistView(){
		return "elasticBoard/elasticRegist";
	}
	
	//insert
	@RequestMapping(name = "elasticRegist", method = RequestMethod.POST)
	public String solrRegist(@ModelAttribute BoardVO vo) throws ElasticsearchException, IOException {
		boardService.elasticRegist(vo);
		return "redirect:/";
	}
	
	//update & delete page
	@RequestMapping("/elasticUpdateView")
	public String elasticUpdateView(BoardVO vo, Model model) throws ElasticsearchException, IOException {
		Object resultVO = elasticProcessor.elasticUpdateView(vo);
		model.addAttribute("view", resultVO);
		
		return "elasticBoard/elasticUpdateView";
	}
	
	//update
	@RequestMapping("/elasticUpdate")
	public String elasticUpdate(BoardVO vo, Model model) throws ElasticsearchException, IOException {
		boardService.elasticUpdate(vo);
		
		return "redirect:/";
	}
	
	//delete
	@RequestMapping("/elasticDelete")
	public String elasticDelete(BoardVO vo, Model model) throws ElasticsearchException, IOException {
		boardService.elasticDelete(vo);
		
		return "redirect:/";
	}
	
}
