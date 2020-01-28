package com.takim.siem.jdbc.dao;

import java.util.List;

import com.takim.siem.jdbc.model.JdbcInfo;
import com.takim.siem.jdbc.model.KeyInfo;

public interface JdbcWebDao {

	List<JdbcInfo> selectJdbcInfoList();

	JdbcInfo selectOneJdbcInfo(String idx);

	void insertScheduler(JdbcInfo jdbcVO);

	void insertTableKey(KeyInfo keyVO);

	void deleteScheduler(String idx);

	void deleteKey(String idx);

	KeyInfo selectOneKeyInfo(String idx);

	void updateScheduler(JdbcInfo jdbcVO);

	void uptateTableKey(KeyInfo keyVO);

}
