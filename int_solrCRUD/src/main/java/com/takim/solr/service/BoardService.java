package com.takim.solr.service;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

import com.takim.solr.vo.BoardVO;

public interface BoardService {

	//insert
	public void solrRegist(BoardVO vo) throws SolrServerException, IOException;

	//update
	public void solrUpdate(BoardVO vo) throws SolrServerException, IOException;

	//delete
	public void solrDelete(BoardVO vo) throws SolrServerException, IOException;

}
