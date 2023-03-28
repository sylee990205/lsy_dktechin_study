package day17;

import java.util.ArrayList;
import java.util.List;

public class ThreadEx19 {
	public static void main(String[] args) throws Exception {
		List<Character> buffer = new ArrayList<>();
		Thread t1 = new ShareThread1(buffer);
		Thread t2 = new ShareThread2(buffer);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("버퍼의 크기 : " + buffer.size());
		for (char e : buffer)
			System.out.print(e);
	}
}


class ShareThread1 extends Thread {
	List<Character> buffer = null; 

	ShareThread1(List<Character> buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 65; i < 91; i++)
			buffer.add((char) (i));
	}
}

class ShareThread2 extends Thread {
	List<Character> buffer = null;

	ShareThread2(List<Character> buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 97; i < 123; i++)
			buffer.add((char) (i));
	}
}
