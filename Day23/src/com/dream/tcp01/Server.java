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
			//连接一个客户端，就要生成一个与之对应的socket
			Socket socket = server.accept();
			
			//获取客户端的IP地址
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println(ip);
			//存入map中
			map.put(ip, socket);
			
			//创建子线程（目的：专门服务这个socket，负责接收此socket发来的数据，并转发给其他存在map中socket对象）
			new ServerReceive(socket,map).start();
		}
	}
}
//专门负责接收此socket对象的数据，并发送给其他socket的线程
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
				//获取到数据
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

