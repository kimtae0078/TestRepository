package com.takim.elastic.util;

import java.net.InetSocketAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticConnection {

	
	// 엘라스틱 연동
	private static Settings settings = Settings.builder().put("node.name", "takimNode").build();
	public static TransportClient client = new PreBuiltTransportClient(settings)
			.addTransportAddress(new TransportAddress(new InetSocketAddress("172.16.100.177", 9300)));
	
	
}
