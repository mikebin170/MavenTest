package com.testfan.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientBaidu {

	public static void main(String[] args) {
		// 默认配置，包括连接池
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

		// 构造请求
		HttpGet get = new HttpGet("http://www.baidu.com");

		BufferedReader in = null;
		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(get);

			 entity = closeableHttpResponse.getEntity();
			// 第一种结果处理
//			in = new BufferedReader(new InputStreamReader(entity.getContent()));
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += line;
//			}
//			System.out.println(result);
			//第二种用法
			result = EntityUtils.toString(entity,"utf-8");
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
