package com.dream.http;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test03 {
	
	public static void main(String[] args) throws Exception {
		
		//���ӵ�ַ
		URL url = new URL("http://www.kuaidi100.com/query?type=shentong&postid=3705270205072");
		
		//��ȡ���Ӷ���
		HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
		//��������
		conn.setConnectTimeout(5000);//��������ʱ�� 
		conn.setReadTimeout(5000);//���ö�ȡ��ʱʱ��
		conn.setDoOutput(true);//���������
		conn.setDoInput(true);//����������
		conn.setRequestMethod("GET");//��������ʽ GET/POST
		
		int responseCode = conn.getResponseCode();//��ȡ��Ӧ״̬
		if(responseCode == HttpURLConnection.HTTP_OK){//���ӳɹ�
			
			//��ȡ���� --- IO��
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			
			char[] cbuf = new char[1024];
			int len;
			while((len = isr.read(cbuf)) != -1){
				System.out.println(new String(cbuf, 0, len));
			}
			
		}else if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("������ҳδ�ҵ�����");
		}
		
	}

}
