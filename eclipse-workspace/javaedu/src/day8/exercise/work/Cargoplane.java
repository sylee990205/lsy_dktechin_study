// java Day8 exercise
package day8.exercise.work;

public class Cargoplane extends Plane{
	public Cargoplane(){
		
	}
	
	public Cargoplane(String planeName, int fuelSize){
		super(planeName,fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		super.setFuelSize(super.getFuelSize()-(distance * 5));
	}
	
}
