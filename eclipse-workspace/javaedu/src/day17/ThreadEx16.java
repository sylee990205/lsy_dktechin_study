package day17;

public class ThreadEx16 {
	public static void main(String argc[]) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "]" + " thread starts here...");

		Thread t1 = new Thread(new MyRunnableTask(100), "Thread-ONE");
		Thread t2 = new Thread(new MyRunnableTask(500), "Thread-TWO");

		t2.setDaemon(true);

		t1.start();
		t2.start();

		System.out.println("[" + currentThreadName + "]" + " thread ends here...");
	}
}

class MyRunnableTask implements Runnable {
	private static int count = 0;
	private int id;
	private String taskId;
	private long sleepTime;

	@Override
	public void run() {
		boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();
		String threadType = isRunningInDaemonThread ? "DAEMON" : "USER";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("#### <" + currentThreadName + "," + threadType + "," + taskId + "> starting...####");
		for (int i = 0; i < 10; i++) {
			System.out.println("<" + currentThreadName + "," + threadType + "," + taskId + "> TICK TICK" + i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#### <" + currentThreadName + "," + threadType + "," + taskId + "> done...####");
	}

	public MyRunnableTask(long sleepTime) {
		this.id = ++count;
		this.taskId = "MyRunnableTask" + id;
		this.sleepTime = sleepTime;
	}
}
