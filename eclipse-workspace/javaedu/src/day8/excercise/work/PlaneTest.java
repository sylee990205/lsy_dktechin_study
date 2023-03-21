// java Day8 excercise
package day8.excercise.work;

public class PlaneTest {

	public static void main(String[] args) {
		Plane[] plane = new Plane[2];
		plane[0] = new Airplane("L747",1000);
		plane[1] = new Cargoplane("C40",1000);
		
		printInfo(plane);
		
		System.out.println("\n [100 운항]");
		
		for(Plane e: plane) {
			e.flight(100);
		}
		
		printInfo(plane);
		
		System.out.println("\n [200 주유]");
		for(Plane e: plane) {
			e.refuel(200);
		}
		
		printInfo(plane);

	}
	
	public static void printInfo(Plane[] list) {
		System.out.println("  Plane\t\tfuelSize");
		System.out.println("--------------------------");
		
		for(Plane e: list) {
			System.out.println("  " + e.getPlaneName() + "\t\t" + e.getFuelSize());
			
		}
		
	}

}
