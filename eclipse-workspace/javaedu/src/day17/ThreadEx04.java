package day17;

class ThreadEx04 {
	public static void main(String args[]) throws InterruptedException {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", new String("-"));
			Thread.sleep(1000);
		}
		// System.out.println("소요시간1:" +(System.currentTimeMillis()- startTime));

		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", new String("|"));
			Thread.sleep(1000);
		}

		System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));
	}
}
