package com.dream.http;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test02 {
	
	public static void main(String[] args) throws Exception {
		
		//���ӵ�ַ
		URL url = new URL("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15879090131");
		
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
			
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1){
				System.out.println(new String(b, 0, len));
			}
			
		}else if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("������ҳδ�ҵ�����");
		}
		
	}

}
