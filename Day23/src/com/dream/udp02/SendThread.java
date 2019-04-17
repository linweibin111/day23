package com.dream.udp02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SendThread extends Thread{
	
	private String name;
	private DatagramSocket socket;
	private String ip;
	private int port;
	
	public SendThread(String name, DatagramSocket socket, String ip, int port) {
		this.name = name;
		this.socket = socket;
		this.ip = ip;
		this.port = port;
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true){
			String str = name + "£º" + scan.next();
			byte[] buf = str.getBytes();
			try {
				DatagramPacket p = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), port);
				socket.send(p);
			} catch (UnknownHostException e) {
			} catch (IOException e) {
			}
		}
	}
}
