package com.dream.http;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test01 {
	
	public static void main(String[] args) throws Exception {
		
		//链接地址
		URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1555482150&di=91569e0ef463ae4f072fb1b7e15961fa&src=http://image13.m1905.cn/uploadfile/2013/1206/20131206015203607650_watermark.jpg");
		
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
			FileOutputStream fos = new FileOutputStream("柳岩.jpg");
			
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1){
				fos.write(b, 0, len);
			}
			
			fos.close();
		}else if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("发生网页未找到错误");
		}
		
	}

}
