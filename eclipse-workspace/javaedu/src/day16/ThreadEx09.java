package day16;

public class ThreadEx09 {
	public static void main(String[] args) throws Exception {
		Thread mainThread = Thread.currentThread();
		System.out.println("[ 프로그램 시작 스레드 이름 ] : " + mainThread.getName());
		System.out.println("-------------------------------");
		threadA2 threadA = new threadA2();
		System.out.println("작업 스레드 이름: " + threadA.getName());

		threadB2 threadB = new threadB2("threadB2");
		System.out.println("작업 스레드 이름: " + threadB.getName());

		threadC2 threadC = new threadC2();
		System.out.println("작업 스레드 이름: " + threadC.getName());
		threadA.start();
		threadB.start();
		threadC.start();
		threadA.join();
		threadB.join();
		threadC.join();

		for (int i = 0; i < 3; i++)
			System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());
	}
}

class threadA2 extends Thread {
	public threadA2() {
		setName("threadA2");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}

class threadB2 extends Thread {
	public threadB2(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}

class threadC2 extends Thread {
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}