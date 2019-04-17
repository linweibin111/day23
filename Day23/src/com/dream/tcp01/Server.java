package com.dream.tcp01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8080);
		
		ConcurrentHashMap<String, Socket> map = new ConcurrentHashMap<>();
		
		while(true){
			//����һ���ͻ��ˣ���Ҫ����һ����֮��Ӧ��socket
			Socket socket = server.accept();
			
			//��ȡ�ͻ��˵�IP��ַ
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println(ip);
			//����map��
			map.put(ip, socket);
			
			//�������̣߳�Ŀ�ģ�ר�ŷ������socket��������մ�socket���������ݣ���ת������������map��socket����
			new ServerReceive(socket,map).start();
		}
	}
}
//ר�Ÿ�����մ�socket��������ݣ������͸�����socket���߳�
class ServerReceive extends Thread{
	
	private Socket socket;
	private ConcurrentHashMap<String, Socket> map;
	
	public ServerReceive(Socket socket, ConcurrentHashMap<String, Socket> map) {
		this.socket = socket;
		this.map = map;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
		} catch (Exception e) {
		}
		
		while(true){
			PrintStream ps = null;
			try {
				//��ȡ������
				String readLine = br.readLine();
				
				System.out.println(readLine);
				
				Set<Entry<String,Socket>> entrySet = map.entrySet();
				for (Entry<String, Socket> entry : entrySet) {
					String ip = entry.getKey();
					if(!ip.equals(socket.getInetAddress().getHostAddress())){
						
						ps = new PrintStream(entry.getValue().getOutputStream());
						ps.println(readLine);
						
					}
				}
			} catch (IOException e) {
			}
		}
	}
}

