package com.dream.tcp01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//�ͻ���
public class Client {

	public static void main(String[] args) throws Exception{

		//�Ż�һ��һ����

		Socket socket = new Socket("127.0.0.1", 8080);

		Scanner scan = new Scanner(System.in);
		PrintStream ps = new PrintStream(socket.getOutputStream());

		//�������������Ͻ�����Ϣ���߳�
		new ReceiveThread(socket).start();
		
		while(true){
			ps.println("��ƣ�" + scan.nextLine());
		}
	}
}
