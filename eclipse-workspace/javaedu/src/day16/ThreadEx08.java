package day16;

public class ThreadEx08 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("[ 프로그램 시작 스레드 이름 ] : " + mainThread.getName());
		System.out.println("-------------------------------");
		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름: " + threadA.getName());

		ThreadB threadB = new ThreadB("ThreadB");
		System.out.println("작업 스레드 이름: " + threadB.getName());

		ThreadC threadC = new ThreadC();
		System.out.println("작업 스레드 이름: " + threadC.getName());
		threadA.start();
		threadB.start();
		threadC.start();

		for (int i = 0; i < 3; i++)
			System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());
	}
}

class ThreadA extends Thread {
	public ThreadA() {
		setName("ThreadA");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}

class ThreadB extends Thread {
	public ThreadB(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}

class ThreadC extends Thread {
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}