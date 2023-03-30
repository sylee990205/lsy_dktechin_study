package day18;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpServer5 {

	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(8888);
			System.out.println("[ 메시지 송수신 서버가 준비되었습니다. ]");

			socket = serverSocket.accept();		

			Sender sender = new Sender(socket); // 출력 스트림으로 출력
			Receiver receiver = new Receiver(socket); // 입력 스트림으로 입력

			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
} 

class Sender extends Thread {
	Socket socket;
	OutputStreamWriter out;
	String name;

	Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");			
			name = "[수신]";
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(out!=null) {
			try {
				out.write(name+scanner.nextLine()+"\r\n");		
				out.flush();
			} catch(IOException e) {
			e.printStackTrace();
		}
		}
		scanner.close();
	} 
}

class Receiver extends Thread {
	Socket socket;
	BufferedReader in;

	Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readLine());
			} catch(IOException e) {}
		}
	} // run
}