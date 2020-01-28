package com.takim.solr.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import com.takim.solr.vo.BoardVO;

public class SolrProcessor {
	private final static SolrConnection solrConnection = new SolrConnection();
	
	//selectAll
	public static Object selectAll(BoardVO vo) throws SolrServerException, IOException {
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("*:*");
		solrQuery.setSort("rowNum",ORDER.desc);
		solrQuery.setRows(50);
		
		QueryResponse response = solrConnection.solr.query(solrQuery);
		SolrDocumentList results = response.getResults();
		
		Object list = results.toArray();

		return list;
	}
	
	//search
	public static Object selectSearchAll(String keyword, String option) throws SolrServerException, IOException {

		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(option + ":*"+ keyword + "*"); // search
		solrQuery.setSort("rowNum",ORDER.desc);
		solrQuery.setRows(50);

		QueryResponse response = solrConnection.solr.query(solrQuery);
		SolrDocumentList results = response.getResults();
		Object list = results.toArray();
		return list;
	}

	
	//insert
	public static void addDoc(BoardVO vo) throws SolrServerException, IOException {
		
		SolrInputDocument solrDoc = new SolrInputDocument();
		solrDoc.addField("id", vo.getIdx());
		solrDoc.addField("idx", vo.getIdx());
		solrDoc.addField("rowNum", vo.getRow_num());
		solrDoc.addField("subject", vo.getSubject());
		solrDoc.addField("content", vo.getContent());
		solrDoc.addField("date", vo.getDate());
		//collection 생성
		Collection<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();
		solrDocs.add(solrDoc);

		//solr 접속 client
		solrConnection.solr.add(solrDocs);
		solrConnection.solr.commit();
		
	}
	
	//rowNum + 1 logic
	public static void rowNumUpdate(BoardVO vo) throws SolrServerException, IOException {
			
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("*:*");
		solrQuery.setSort("rowNum",ORDER.desc);
				
		QueryResponse response = solrConnection.solr.query(solrQuery);
		SolrDocumentList results = response.getResults();
		
		if(results.size() > 0) {
			SolrDocument result = results.get(0);
			vo.setRow_num((int) result.getFieldValue("rowNum")+1);
		}else {
			vo.setRow_num(1);
		}
		
	}

	//update form
 	public static Object solrUpdateView(BoardVO vo) throws SolrServerException, IOException {

 		SolrQuery solrQuery = new SolrQuery();
 		//==solrQuery.setQuery("idx:"+vo.getIdx());
		solrQuery.setQuery("*:*");
		solrQuery.setFilterQueries("idx:"+vo.getIdx());
		
		QueryResponse response = solrConnection.solr.query(solrQuery);
		SolrDocumentList results = response.getResults();
		
		Object boardVO = results.toArray();
		return boardVO;
	}

 	//update
	public static void solrUpdate(BoardVO vo) throws SolrServerException, IOException {
		// field추가 (date제외)
		SolrInputDocument solrDoc = new SolrInputDocument();
		solrDoc.addField("id", vo.getIdx());
		solrDoc.addField("rowNum", vo.getRow_num());
		solrDoc.addField("idx", vo.getIdx());
		solrDoc.addField("subject", vo.getSubject());
		solrDoc.addField("content", vo.getContent());
		solrDoc.addField("date", vo.getDate());
		System.out.println(vo.toString());

		// collection 생성
		Collection<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();
		solrDocs.add(solrDoc);

		// solr 접속 client 생성
		solrConnection.solr.add(solrDocs);
		solrConnection.solr.commit();
		
	}

	//delete
	public static void solrDelete(BoardVO vo) throws SolrServerException, IOException {
		
		solrConnection.solr.deleteById(vo.getIdx());
		solrConnection.solr.commit();
		
	}

		
	
	

	
	
	
}
