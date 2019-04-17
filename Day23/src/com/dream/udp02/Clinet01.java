package com.dream.udp02;

import java.net.DatagramSocket;

public class Clinet01 {

	public static void main(String[] args) throws Exception{
		
		DatagramSocket socket = new DatagramSocket(8080);
		
		new SendThread("ÂÞ³¬", socket, "127.0.0.1", 9090).start();
		new ReceiveThread(socket).start();
	}
}
