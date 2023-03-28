package day17;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadEx19_sync2 {
	public static void main(String[] args) throws Exception {
		List<Character> buffer = new CopyOnWriteArrayList<>();
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
