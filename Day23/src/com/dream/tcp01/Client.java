package com.dream.tcp01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//客户端
public class Client {

	public static void main(String[] args) throws Exception{

		//优化一对一聊天

		Socket socket = new Socket("127.0.0.1", 8080);

		Scanner scan = new Scanner(System.in);
		PrintStream ps = new PrintStream(socket.getOutputStream());

		//创建并开启不断接收消息的线程
		new ReceiveThread(socket).start();
		
		while(true){
			ps.println("李科：" + scan.nextLine());
		}
	}
}
