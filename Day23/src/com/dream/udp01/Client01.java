package com.dream.udp01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client01 {

	public static void main(String[] args) throws Exception{
		
		
		//�޳����ڵصĿ�ݹ�˾
		DatagramSocket socket = new DatagramSocket();//UDP���׽��ֶ���
		
		//1.�����������ڵصĿ�ݹ�˾���Ͱ���
		byte[] buf = "����β��...".getBytes();
		DatagramPacket p = new DatagramPacket(buf , 0, buf.length, InetAddress.getByName("127.0.0.1"), 8080);
		socket.send(p);//���Ͱ���
		
		//4.�����������Ļ���
		buf = new byte[1024];
		p = new DatagramPacket(buf, buf.length);
		socket.receive(p);
		System.out.println(new String(buf).trim());
		
	}
}
