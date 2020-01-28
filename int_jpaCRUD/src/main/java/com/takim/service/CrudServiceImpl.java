package com.takim.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takim.model.CrudVO;
import com.takim.repository.CrudRepository;

@Service("crudService")
public class CrudServiceImpl implements CrudService {

	@Autowired
	private CrudRepository repo;
	
	//리스트 호출
	@Override
	public List<CrudVO> selectList(){
		return repo.selectList(); 
	}
	
	//글 등록
	@Override
	public void jpaRegist(CrudVO vo){
		vo.setIdx(UUID.randomUUID().toString());
		repo.jpaRegist(vo); 
	}
	
	//수정 페이지 이동
	@Override
	public CrudVO jpaView(CrudVO vo){
		return repo.jpaView(vo); 
	}
	
	//글 수정
	@Override
	public void jpaUpdate(CrudVO vo) {
		repo.jpaUpdate(vo);
	}
	
	//글 삭제
	@Override
	public void jpaDelete(CrudVO vo) {
		repo.jpaDelete(vo);
	}
}
