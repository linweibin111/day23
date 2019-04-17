package com.dream.udp01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client01 {

	public static void main(String[] args) throws Exception{
		
		
		//罗超所在地的快递公司
		DatagramSocket socket = new DatagramSocket();//UDP的套接字对象
		
		//1.向闵宇轩所在地的快递公司发送包裹
		byte[] buf = "狐狸尾巴...".getBytes();
		DatagramPacket p = new DatagramPacket(buf , 0, buf.length, InetAddress.getByName("127.0.0.1"), 8080);
		socket.send(p);//发送包裹
		
		//4.接收闵宇轩的回礼
		buf = new byte[1024];
		p = new DatagramPacket(buf, buf.length);
		socket.receive(p);
		System.out.println(new String(buf).trim());
		
	}
}
