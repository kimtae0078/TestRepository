package com.takim.repository;

import java.util.List;

import com.takim.model.CrudVO;

public interface CrudRepository {

	//리스트 호출
	public List<CrudVO> selectList();

	//글 등록
	public void jpaRegist(CrudVO vo);

	//수정 페이지 이동
	public CrudVO jpaView(CrudVO vo);

	//글 수정
	public void jpaUpdate(CrudVO vo);
	
	//삭제
	public void jpaDelete(CrudVO vo);

	

}
