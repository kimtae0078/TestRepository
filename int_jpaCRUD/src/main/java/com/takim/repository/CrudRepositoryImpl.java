package com.takim.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.View;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.takim.model.CrudVO;

@Repository("crudRepository")
public class CrudRepositoryImpl implements CrudRepository {

	@PersistenceContext
	private EntityManager em;
	
	//리스트 호출
	@Transactional
	@Override
	public List<CrudVO> selectList() {
		return em.createQuery("select c from CrudVO c where c.is_deleted = false", CrudVO.class).getResultList();
	}
	
	//글 등록
	@Transactional
	@Override
	public void jpaRegist(CrudVO vo) {
		em.persist(vo);
	}
	
	//수정 페이지 이동
	@Transactional
	@Override
	public CrudVO jpaView(CrudVO vo) {
		return em.createQuery("select c from CrudVO c where c.idx = :idx", CrudVO.class).setParameter("idx", vo.getIdx()).getSingleResult();
	}
	
	//글 수정
	@Transactional
	@Override
	public void jpaUpdate(CrudVO vo) {
		em.merge(vo);
	}
	
	//글 삭제
	@Transactional
	@Override
	public void jpaDelete(CrudVO vo) {
		CrudVO delVO = jpaView(vo);
		delVO.setIs_deleted(true);
	}
	
}	
