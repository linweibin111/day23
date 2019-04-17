package com.dream.http;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test02 {
	
	public static void main(String[] args) throws Exception {
		
		//链接地址
		URL url = new URL("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15879090131");
		
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
			
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1){
				System.out.println(new String(b, 0, len));
			}
			
		}else if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("发生网页未找到错误");
		}
		
	}

}
