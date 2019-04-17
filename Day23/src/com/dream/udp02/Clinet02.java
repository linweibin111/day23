package com.dream.udp02;

import java.net.DatagramSocket;

public class Clinet02 {

	public static void main(String[] args) throws Exception{

		DatagramSocket socket = new DatagramSocket(9090);

		new SendThread("ãÉÓîĞù", socket, "127.0.0.1", 8080).start();
		new ReceiveThread(socket).start();
	}
}
