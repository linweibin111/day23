package com.dream.http;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test01 {
	
	public static void main(String[] args) throws Exception {
		
		//���ӵ�ַ
		URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1555482150&di=91569e0ef463ae4f072fb1b7e15961fa&src=http://image13.m1905.cn/uploadfile/2013/1206/20131206015203607650_watermark.jpg");
		
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
			FileOutputStream fos = new FileOutputStream("����.jpg");
			
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1){
				fos.write(b, 0, len);
			}
			
			fos.close();
		}else if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("������ҳδ�ҵ�����");
		}
		
	}

}
