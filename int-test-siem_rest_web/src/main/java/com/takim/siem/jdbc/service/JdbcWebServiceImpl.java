package com.takim.siem.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takim.siem.jdbc.dao.JdbcWebDao;
import com.takim.siem.jdbc.model.JdbcInfo;
import com.takim.siem.jdbc.model.KeyInfo;

@Service
public class JdbcWebServiceImpl implements JdbcWebService{

	@Autowired
	JdbcWebDao jdbcWebDao;
	
	@Override
	public List<JdbcInfo> selectJdbcInfoList() {
		return jdbcWebDao.selectJdbcInfoList();
	}

	@Override
	public JdbcInfo selectOneJdbcInfo(String idx) {
		return jdbcWebDao.selectOneJdbcInfo(idx);
	}

	@Override
	public void insertScheduler(JdbcInfo jdbcVO) {
		jdbcWebDao.insertScheduler(jdbcVO);
	}

	@Override
	public void insertTableKey(KeyInfo keyVO) {
		jdbcWebDao.insertTableKey(keyVO);
	}

	@Override
	public void deleteScheduler(String idx) {
		jdbcWebDao.deleteScheduler(idx);
	}

	@Override
	public void deleteKey(String idx) {
		jdbcWebDao.deleteKey(idx);
	}

	@Override
	public KeyInfo selectOneKeyInfo(String idx) {
		return jdbcWebDao.selectOneKeyInfo(idx);
	}

	@Override
	public void updateScheduler(JdbcInfo jdbcVO) {
		jdbcWebDao.updateScheduler(jdbcVO);
	}

	@Override
	public void uptateTableKey(KeyInfo keyVO) {
		jdbcWebDao.uptateTableKey(keyVO);
	}

}
