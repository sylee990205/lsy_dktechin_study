package day17;

class FamilyThread extends Thread {
	private Washroom wr;
	private String who;

	public FamilyThread(Washroom wr, String who) {
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

class Washroom {
	public void openDoor(String name) throws InterruptedException {
		System.out.println(name + "님이 입장");
		for (int i = 0; i < 50000; i++) {
			if (i % 10000 == 0) {
				Thread.sleep(500);
				System.out.println(name + "님이 볼일보는중..");
			}
		}
		System.out.println(name + "님이 퇴장");
	}
}

public class ThreadEx18 {
	public static void main(String[] args) {
		Washroom wr = new Washroom();

		FamilyThread father = new FamilyThread(wr, "father");
		FamilyThread mother = new FamilyThread(wr, "mother");
		FamilyThread sister = new FamilyThread(wr, "sister");
		FamilyThread brother = new FamilyThread(wr, "brother");
		FamilyThread me = new FamilyThread(wr, "me");

		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();
	}
}
