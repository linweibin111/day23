package com.dream.tcp02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(8080);
		
		System.out.println("等待玩家加入对战：");

		Socket socket = server.accept();
		
		System.out.println("有个不怕死的进来了....");
		
		GoBang goBang = new GoBang();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(true){
			
			if(flag){
				//接收来自客户端的棋子坐标
				int clientX = Integer.parseInt(br.readLine());
				int clientY = Integer.parseInt(br.readLine());
				goBang.play(clientX, clientY, true);
				goBang.printGoBang();
			}
			
			System.out.println("请输入白子坐标：");
			String next = scan.next();//"17,18"
			String[] split = next.split(",");//"17" 和 "18"
			int x = Integer.parseInt(split[0])-1;
			int y = Integer.parseInt(split[1])-1;
			int play = goBang.play(x, y, false);
			if(play == -1){
				System.out.println("坐标超出棋盘范围 ,请重新输入...");
				flag = false;
				continue;
			}else if(play == -2){
				System.out.println("坐标上已有棋子 ,请重新输入...");
				flag = false;
				continue;
			}
			goBang.printGoBang();
			flag = true;
			
			//向客户端发送棋子坐标
			ps.println(x);
			ps.println(y);
			
		}
	}
}
