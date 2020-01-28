package com.takim.solr.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;
import com.takim.solr.util.SolrProcessor;
import com.takim.solr.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	private SolrProcessor solrProcessor = new SolrProcessor();

	//insert
	@Override
	public void solrRegist(BoardVO vo) throws SolrServerException, IOException {
			
		// setidx
		vo.setIdx(UUID.randomUUID().toString());
		// setdate
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = mSimpleDateFormat.format(currentTime);
		vo.setDate(date);
		//rowNum 증가
		solrProcessor.rowNumUpdate(vo);
		// solr 추가
		solrProcessor.addDoc(vo);
	}

	//update
	@Override
	public void solrUpdate(BoardVO vo) throws SolrServerException, IOException {
		solrProcessor.solrUpdate(vo);
	}

	//delete
	@Override
	public void solrDelete(BoardVO vo) throws SolrServerException, IOException {
		solrProcessor.solrDelete(vo);
		
	}

	
	
}
