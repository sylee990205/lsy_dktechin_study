package day17;

class ThreadEx02 {
	public static void main(String args[]) throws Exception {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		// start가 콜스택을 하나 만들고 run을 호출함. --> 스레드가 기동될 때 마다 기동되는 콜스택 하나가 무조건 생김
		t1.start();
	}
}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			//콜스택을 본다 == 예외가 발생했다
			e.printStackTrace();
		}
	}
}
