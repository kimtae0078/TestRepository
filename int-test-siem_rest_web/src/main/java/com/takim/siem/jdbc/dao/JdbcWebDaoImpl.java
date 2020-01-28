package com.takim.siem.jdbc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.takim.siem.jdbc.model.JdbcInfo;
import com.takim.siem.jdbc.model.KeyInfo;

@Repository
public class JdbcWebDaoImpl implements JdbcWebDao{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "jdbcWebMapper";
	
	@Override
	public List<JdbcInfo> selectJdbcInfoList() {
		return sqlSession.selectList(namespace + ".selectJdbcInfoList");
	}

	@Override
	public JdbcInfo selectOneJdbcInfo(String idx) {
		return sqlSession.selectOne(namespace + ".selectOneJdbcInfo", idx);
	}

	@Override
	public void insertScheduler(JdbcInfo jdbcVO) {
		sqlSession.insert(namespace + ".insertScheduler", jdbcVO);
	}

	@Override
	public void insertTableKey(KeyInfo keyVO) {
		sqlSession.insert(namespace + ".insertTableKey", keyVO);
	}

	@Override
	public void deleteScheduler(String idx) {
		sqlSession.insert(namespace + ".deleteScheduler", idx);
	}

	@Override
	public void deleteKey(String idx) {
		sqlSession.insert(namespace + ".deleteKey", idx);
	}

	@Override
	public KeyInfo selectOneKeyInfo(String idx) {
		return sqlSession.selectOne(namespace + ".selectOneKeyInfo", idx);
	}

	@Override
	public void updateScheduler(JdbcInfo jdbcVO) {
		sqlSession.update(namespace + ".updateScheduler", jdbcVO);
	}

	@Override
	public void uptateTableKey(KeyInfo keyVO) {
		sqlSession.update(namespace + ".uptateTableKey", keyVO);
	}

	
}
