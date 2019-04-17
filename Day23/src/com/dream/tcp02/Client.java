package com.dream.tcp02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket("127.0.0.1",8080);
		
		GoBang goBang = new GoBang();
		
		Scanner scan = new Scanner(System.in);
		
		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
		while(true){
			
			System.out.println("输入黑子坐标：");
			String next = scan.next();//"17,18"
			String[] split = next.split(",");//"17" 和 "18"
			int x = Integer.parseInt(split[0])-1;
			int y = Integer.parseInt(split[1])-1;
			
			int play = goBang.play(x, y, true);
			if(play == -1){
				System.out.println("坐标超出棋盘范围 ,请重新输入...");
				continue;
			}else if(play == -2){
				System.out.println("坐标上已有棋子 ,请重新输入...");
				continue;
			}
			goBang.printGoBang();
			
			//向服务端发送棋子坐标
			ps.println(x);
			ps.println(y);
			
			//接收来自客户端的棋子坐标
			int serverX = Integer.parseInt(br.readLine());
			int serverY = Integer.parseInt(br.readLine());
			goBang.play(serverX, serverY, false);
			goBang.printGoBang();
		}
		
	}
}
