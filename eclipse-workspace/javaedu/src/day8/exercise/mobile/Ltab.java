// java Day8 exercise
package day8.exercise.mobile;

public class Ltab extends Mobile{
	public Ltab(){
		
	}
	
	public Ltab(String mobileName, int batterySize, String osType){
		super(mobileName,batterySize,osType);
	}
	
	@Override
	public void operate(int time) {
//		int useBattery;
//		useBattery = super.getBatterySize() - (time * 10);
//		super.setBatterySize(useBattery);
		
		// 이렇게 한번에 할 수 있다.
		super.setBatterySize(getBatterySize() - (time * 10));
	}
	
	@Override
	public void charge(int time) {
//		int chargeBattery;
//		chargeBattery = super.getBatterySize() + (time * 10);
//		super.setBatterySize(chargeBattery);
		
		super.setBatterySize(getBatterySize() + (time * 10)); 
	}
	
}
