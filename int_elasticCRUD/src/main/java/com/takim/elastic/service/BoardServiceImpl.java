package com.takim.elastic.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.elasticsearch.ElasticsearchException;
import org.springframework.stereotype.Service;

import com.takim.elastic.util.ElasticProcessor;
import com.takim.elastic.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	private ElasticProcessor elasticProcessor = new ElasticProcessor();
	
	//insert
	@Override
	public void elasticRegist(BoardVO vo) throws ElasticsearchException, IOException {

		// setidx
		vo.setIdx(UUID.randomUUID().toString());
		// setdate
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		String date = mSimpleDateFormat.format(currentTime);
		vo.setDate(date);
		//row_num증가
		elasticProcessor.rowNumUpdate(vo);
		//elasticsearch 추가
		elasticProcessor.addDoc(vo);
	}

	//update
	@Override
	public void elasticUpdate(BoardVO vo) throws ElasticsearchException, IOException {
		elasticProcessor.elasticUpdate(vo);
	}

	//delete
	@Override
	public void elasticDelete(BoardVO vo) throws ElasticsearchException, IOException {
		elasticProcessor.elasticDelete(vo);
		
	}

	
	
	
}
