package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {
	HashMap<String, OutputStreamWriter> clients;

	TcpIpMultichatServer() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}

	public void operate() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("[ 챗서버가 시작되었습니다. ]");

			while (true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			OutputStreamWriter out = clients.get(it.next());
			try {
				out.write(msg+"\r\n");
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		new TcpIpMultichatServer().operate();
	}

	class ServerReceiver extends Thread {
		Socket socket;
		BufferedReader in;
		OutputStreamWriter out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String name = "";
			try {
				name = in.readLine();
				sendToAll("#" + name + "님이 들어오셨습니다.");

				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

				while (in != null) {
					sendToAll(in.readLine());
				}
			} catch (IOException e) {
				//e.printStackTrace();
			} finally {
				clients.remove(name);
				sendToAll("#" + name + "님이 나가셨습니다.");
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
			}
		}
	}
}
