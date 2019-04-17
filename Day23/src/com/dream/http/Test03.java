package com.dream.http;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test03 {
	
	public static void main(String[] args) throws Exception {
		
		//链接地址
		URL url = new URL("http://www.kuaidi100.com/query?type=shentong&postid=3705270205072");
		
		//获取连接对象
		HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
		//设置内容
		conn.setConnectTimeout(5000);//设置连接时间 
		conn.setReadTimeout(5000);//设置读取超时时间
		conn.setDoOutput(true);//设置输出流
		conn.setDoInput(true);//设置输入流
		conn.setRequestMethod("GET");//设置请求方式 GET/POST
		
		int responseCode = conn.getResponseCode();//获取响应状态
		if(responseCode == HttpURLConnection.HTTP_OK){//连接成功
			
			//获取数据 --- IO流
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			
			char[] cbuf = new char[1024];
			int len;
			while((len = isr.read(cbuf)) != -1){
				System.out.println(new String(cbuf, 0, len));
			}
			
		}else if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("发生网页未找到错误");
		}
		
	}

}
