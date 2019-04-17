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
			
			System.out.println("����������꣺");
			String next = scan.next();//"17,18"
			String[] split = next.split(",");//"17" �� "18"
			int x = Integer.parseInt(split[0])-1;
			int y = Integer.parseInt(split[1])-1;
			
			int play = goBang.play(x, y, true);
			if(play == -1){
				System.out.println("���곬�����̷�Χ ,����������...");
				continue;
			}else if(play == -2){
				System.out.println("�������������� ,����������...");
				continue;
			}
			goBang.printGoBang();
			
			//�����˷�����������
			ps.println(x);
			ps.println(y);
			
			//�������Կͻ��˵���������
			int serverX = Integer.parseInt(br.readLine());
			int serverY = Integer.parseInt(br.readLine());
			goBang.play(serverX, serverY, false);
			goBang.printGoBang();
		}
		
	}
}
