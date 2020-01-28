package com.takim.solr.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrConnection {
	
	public static String url = "http://172.16.100.177:8983/solr/new_collection_kta";
	public static SolrClient solr = new HttpSolrClient.Builder(url).build();
}
