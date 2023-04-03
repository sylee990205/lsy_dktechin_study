// java Day8 exercise
package day8.exercise.mobile;

public class MobileTest {

	public static void main(String[] args) {
		Mobile ltab = new Ltab("Ltab",500,"ABC-01");
		Mobile otab = new Otab("Otab",1000,"XYZ-20");
		
		printTitle();
		printMobile(ltab);		
		printMobile(otab);
		
		System.out.println("\n[10분 충전]");
		ltab.charge(10);
		otab.charge(10);
		
		printTitle();
		printMobile(ltab);		
		printMobile(otab);
		
		System.out.println("\n[5분 통화]");
		ltab.operate(5);
		otab.operate(5);
		
		printTitle();
		printMobile(ltab);		
		printMobile(otab);
		}
	
	public static void printMobile(Mobile mobile) {
		System.out.println(" " + mobile.getMobileName() + "\t\t" + mobile.getBatterySize() + "\t\t\t" + mobile.getOsType());
	}
	
	public static void printTitle() {
		System.out.println(" Mobile\t\tBattery\t\t\tOS");
		System.out.println("-------------------------------------------------------------");
	}
}

