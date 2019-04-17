package com.dream.tcp01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

//接收消息的线程
public class ReceiveThread extends Thread{
	
	private BufferedReader br;
	
	public ReceiveThread(Socket socket) {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true){
			try {
				String readLine = br.readLine();
				System.out.println(readLine);
			} catch (IOException e) {
			}
		}
	}
}
