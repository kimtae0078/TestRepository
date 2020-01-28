package com.takim.elastic.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import static org.elasticsearch.common.xcontent.XContentFactory.*;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import com.takim.elastic.vo.BoardVO;




public class ElasticProcessor {

	private final static ElasticConnection elasticConnection = new ElasticConnection();
	
	//selectAll
	public static Object selectAll() throws ElasticsearchException, IOException {
		
		List<Object> listResult = new ArrayList<Object>();
		SearchResponse response = elasticConnection.client.prepareSearch("takimdex")
				.setTypes("board")
				.addSort("row_num", SortOrder.DESC)
				.get();
		
		SearchHits hits = response.getHits();
		
		for(int i = 0; i < hits.totalHits; i++) {
			Map<String, Object> mapResult = hits.getAt(i).getSourceAsMap();
			listResult.add(mapResult);
		}
		
		return listResult;
	}
	
	//rowNum + 1
	public static void rowNumUpdate(BoardVO vo) throws ElasticsearchException, IOException {
		
		SearchResponse response = elasticConnection.client.prepareSearch("takimdex")
				.setTypes("board")
				.addSort("row_num",SortOrder.DESC)
				.get();
		SearchHits hits = response.getHits();
		
		if(hits.totalHits > 0) {
			Map<String, Object> results = hits.getAt(0).getSourceAsMap();
			vo.setRowNum((int) results.get("row_num")+1);
		}else {
			vo.setRowNum(1);
		}
	}
	
	//insert
	public static void addDoc(BoardVO vo) throws ElasticsearchException, IOException {
		
		XContentBuilder builder = jsonBuilder()
				.startObject()
				.field("subject",vo.getSubject())
				.field("content",vo.getContent())
				.field("date", vo.getDate())
				.field("row_num",vo.getRowNum())
				.field("idx",vo.getIdx())
			.endObject();

		IndexResponse response = elasticConnection.client
			.prepareIndex("takimdex", "board")
			.setId(vo.getIdx())
			.setSource(builder)
			.get();
		
	}
	
	//update & delete page
	public static Object elasticUpdateView(BoardVO vo) throws ElasticsearchException, IOException {

		SearchResponse response = elasticConnection.client.prepareSearch("takimdex")
				.setTypes("board")
				.setQuery(QueryBuilders.matchQuery("idx", vo.getIdx()))
				.get();
		
		SearchHits hits = response.getHits();
		
		Map<String, Object> result = hits.getAt(0).getSourceAsMap();
		
		List<Object> listResult = new ArrayList<Object>();
		listResult.add(result);
		
		Object resultVO = listResult.toArray();
		
		return resultVO;
	}
	
	//update
	public static void elasticUpdate(BoardVO vo) throws ElasticsearchException, IOException {
		
		elasticConnection.client.prepareUpdate("takimdex","board",vo.getIdx())
			.setDoc(jsonBuilder()
						.startObject()
							.field("subject",vo.getSubject())
							.field("content",vo.getContent())
						.endObject()).get();
	}

	//delete
	public void elasticDelete(BoardVO vo) throws ElasticsearchException, IOException {

		BulkByScrollResponse response = DeleteByQueryAction.INSTANCE.newRequestBuilder(elasticConnection.client)
				.filter(QueryBuilders.matchQuery("idx", vo.getIdx()))
				.source("takimdex")//index
				.get();
	}
	
	
	
}
