package com.takim.elastic.service;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;

import com.takim.elastic.vo.BoardVO;

public interface BoardService {

	//insert
	void elasticRegist(BoardVO vo) throws ElasticsearchException, IOException;

	//update
	void elasticUpdate(BoardVO vo) throws ElasticsearchException, IOException;

	//delete
	void elasticDelete(BoardVO vo) throws ElasticsearchException, IOException;

}
