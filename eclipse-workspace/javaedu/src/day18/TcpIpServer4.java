package day18;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer4 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;

	public static void main(String args[]) {
		// 5개의 쓰레드를 생성하는 서버를 생성한다.
		TcpIpServer4 server = new TcpIpServer4(5);
		server.operate();
	} // main
	
	public TcpIpServer4(int num) {
		try {
			// 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");

			threadArr = new Thread[num];
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void operate() {
		for(int i=0; i < threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	public void run() {
		while(true) {
			try {
				System.out.println(getTime()+ "가 연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();
				String clientInfo = socket.getInetAddress()+":"+socket.getPort();
				System.out.println(getTime()+ clientInfo + "로부터 연결요청이 들어왔습니다.");
				System.out.println(socket.getLocalPort());
				// 소켓의 출력스트림을 얻는다.
				Thread.sleep(5000);
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out);

				// 원격 소켓(remote socket)에 데이터를 보낸다.
				osw.write("[응대한 스레드-"+Thread.currentThread().getName()+"]"+clientInfo+"님 환영합니다~~");
				System.out.println(getTime()+"가 데이터를 전송했습니다.");

				// 스트림과 소켓을 닫아준다.
				osw.close();
				socket.close();
		    } catch (Exception e) {
				e.printStackTrace();
			}
		} 
	} 
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date()) + name ;
	}
} 
