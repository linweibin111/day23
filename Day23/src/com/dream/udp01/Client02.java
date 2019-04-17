package com.dream.udp01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client02 {

	public static void main(String[] args) throws Exception {
		
		//闵宇轩所在地的快递公司
		DatagramSocket socket = new DatagramSocket(8080);
		
		//2.接收包裹
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf , buf.length);
		socket.receive(p);//接收包裹
		System.out.println(new String(buf).trim());
		
		//3.给罗超回礼
		buf = "东方红和小怪兽".getBytes();
		p = new DatagramPacket(buf, buf.length, p.getSocketAddress());//SocketAddress:IP+端口号
		socket.send(p);
	}
}
