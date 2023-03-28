package day17.excercise;

public class ThreadLab {

	public static void main(String[] args) throws InterruptedException {
		Thread tA = new ThreadA();
		Thread tB = new ThreadB();
		Thread tC = new ThreadC();
		Thread tD = new ThreadD();
		System.out.println("스레드 시작");
		tA.start();
		tB.start();
		tC.start();
		tD.start();
		
		tA.join();
		tB.join();
		tC.join();
		tD.join();
		
		System.out.println("MAIN 수행 종료");
	}

}

class ThreadA extends Thread {
	public void run() {
		for(char upper = 'A'; upper <= 'L'; upper++) {
			System.out.println(upper);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadB extends Thread {
	public void run() {
		for(char lower = 'a'; lower <= 'h'; lower++) {
			System.out.println(lower);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadC extends Thread {
	public void run() {
		for(int i = 1; i <= 30; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadD extends Thread {
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("JAVA");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}