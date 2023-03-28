package day17;

class FamilyThread2 extends Thread {
	private Washroom2 wr;
	private String who;

	public FamilyThread2(Washroom2 wr, String who) {
		this.wr = wr;
		this.who = who;
	}

	@Override
	public void run() {
		try {
			wr.openDoor(who);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Washroom2 {
	public synchronized void openDoor(String name) throws InterruptedException {
		System.out.println(name + "님이 입장");
		for (int i = 0; i < 50000; i++) {
			if (i % 10000 == 0) {
				Thread.sleep(2000);
				System.out.println(name + "님이 볼일보는중..");
			}
		}
		System.out.println(name + "님이 퇴장");
	}
}

public class ThreadEx18_Sync {
	public static void main(String[] args) {
		Washroom2 wr = new Washroom2();

		FamilyThread2 father = new FamilyThread2(wr, "father");
		FamilyThread2 mother = new FamilyThread2(wr, "mother");
		FamilyThread2 sister = new FamilyThread2(wr, "sister");
		FamilyThread2 brother = new FamilyThread2(wr, "brother");
		FamilyThread2 me = new FamilyThread2(wr, "me");

		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();
	}
}
