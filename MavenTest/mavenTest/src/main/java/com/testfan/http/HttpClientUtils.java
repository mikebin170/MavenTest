package com.testfan.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
	// 设置代理IP、端口、协议（请分别替换）
	private static HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");

	// 把代理设置到请求配置ss
	private static RequestConfig defaultRequestConfig = RequestConfig.custom()
			                                           .setConnectTimeout(3000).build();
		                                         // .setProxy(proxy).build();
	// 连接池最大并发连接数
	private static PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
	static {
		manager.setMaxTotal(200);
	}

	// 实例化CloseableHttpClient对象
	private static CloseableHttpClient closeableHttpClient = HttpClients.custom()
			.setConnectionManager(manager)
			.setDefaultRequestConfig(defaultRequestConfig).build();

	// 重载
	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doGet(String url, Map<String, Object> headparams) {

		// 默认配置，包括连接池
		// CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		// 构造请求
		HttpGet get = new HttpGet(url);

		// 头部处理
		if (headparams != null && !headparams.isEmpty()) {
			Set<String> keys = headparams.keySet();
			for (String key : keys) {
				get.addHeader(key, headparams.get(key).toString());
			}
		}

		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(get);
			entity = closeableHttpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 固定写法
	// public static String doPost(String url, Map<String, Object> headparams) {
	//
	// // 默认配置，包括连接池
	// //CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
	// // 构造请求
	// HttpPost post = new HttpPost(url);
	// List<NameValuePair> list=new ArrayList<NameValuePair>();
	// NameValuePair key1 = new BasicNameValuePair("method","loginMobile");
	// list.add(key1);
	// NameValuePair key2 = new BasicNameValuePair("loginname","test1");
	// list.add(key2);
	// NameValuePair key3 = new BasicNameValuePair("loginpass","test1");
	// list.add(key3);
	// UrlEncodedFormEntity postentity = new UrlEncodedFormEntity(list,
	// Consts.UTF_8);
	// // 头部处理
	// if (headparams != null && !headparams.isEmpty()) {
	// Set<String> keys = headparams.keySet();
	// for (String key : keys) {
	// post.addHeader(key, headparams.get(key).toString());
	// }
	// }
	//
	// String result = "";
	// HttpEntity entity = null;
	// try {
	// CloseableHttpResponse closeableHttpResponse =
	// closeableHttpClient.execute(post);
	// entity = closeableHttpResponse.getEntity();
	// result = EntityUtils.toString(entity, "utf-8");
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// EntityUtils.consume(entity);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// return result;
	// }

	// 无header头信息
	public static String doPost(String url, Map<String, Object> paramas) {

		return doPost(url, null, paramas);
	}

	// 封装写法
	public static String doPost(String url, Map<String, Object> headparams, Map<String, Object> paramas) {

		// 默认配置，包括连接池
		// CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		// 构造请求
		HttpPost post = new HttpPost(url);

		if (paramas != null && !paramas.isEmpty()) {
			Set<String> keys = paramas.keySet();
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			for (String key : paramas.keySet()) {
				list.add(new BasicNameValuePair(key, paramas.get(key).toString()));

			}
			UrlEncodedFormEntity postentity = new UrlEncodedFormEntity(list, Consts.UTF_8);
			post.setEntity(postentity);
		}

		if (headparams != null && !headparams.isEmpty()) {
			Set<String> keys = headparams.keySet();
			for (String key : keys) {
				post.addHeader(key, headparams.get(key).toString());
			}
		}

		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
			entity = closeableHttpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String doPostJson(String url, String jsonParam) {
		return doPostJson(url, jsonParam, null);
	}

	public static String doPostJson(String url, String jsonParam, Map<String, Object> headparams) {

		// 默认配置，包括连接池
		// CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		// 构造请求
		HttpPost post = new HttpPost(url);

		if (jsonParam != null) {
			StringEntity json_entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
			json_entity.setContentEncoding("UTF-8");
			json_entity.setContentType("application/json");
			post.setEntity(json_entity);
		}

		if (headparams != null && !headparams.isEmpty()) {
			Set<String> keys = headparams.keySet();
			for (String key : keys) {
				post.addHeader(key, headparams.get(key).toString());
			}
		}

		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
			entity = closeableHttpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String geturl = "http://59.110.139.20:8080/goods/UserServlet?method=loginMobile&loginname=test1&loginpass=test1";
		String result = doGet(geturl);
		System.out.println(result);

		Map<String, Object> headparams = new HashMap<String, Object>();
		headparams.put("token", "123456");
		result = doGet(geturl, headparams);
		System.out.println(result);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("method", "loginMobile");
		params.put("loginname", "test1");
		params.put("loginpass", "test1");
		result = doPost("http://59.110.139.20:8080/goods/UserServlet", params);
		System.out.println(result);

		headparams = new HashMap<String, Object>();
		headparams.put("token", "61b3590090982a0185dda9d3bd793b46");
		doPostJson("http://59.110.139.20:8080/goods/json2", "{\"count\":10}", headparams);

	}

}
