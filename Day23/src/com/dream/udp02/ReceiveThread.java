package com.dream.udp02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread extends Thread{

	private DatagramSocket socket;
	
	public ReceiveThread(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true){
			byte[] buf = new byte[1024];
			DatagramPacket p = new DatagramPacket(buf , buf.length);
			try {
				socket.receive(p);
				System.out.println(new String(buf).trim());
			} catch (IOException e) {
			}
			
		}
	}
}
