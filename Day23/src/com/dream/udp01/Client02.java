package com.dream.udp01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client02 {

	public static void main(String[] args) throws Exception {
		
		//���������ڵصĿ�ݹ�˾
		DatagramSocket socket = new DatagramSocket(8080);
		
		//2.���հ���
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf , buf.length);
		socket.receive(p);//���հ���
		System.out.println(new String(buf).trim());
		
		//3.���޳�����
		buf = "�������С����".getBytes();
		p = new DatagramPacket(buf, buf.length, p.getSocketAddress());//SocketAddress:IP+�˿ں�
		socket.send(p);
	}
}
