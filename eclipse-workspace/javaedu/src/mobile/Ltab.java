// java Day8 excercise
package mobile;

public class Ltab extends Mobile{
	public Ltab(){
		
	}
	
	public Ltab(String mobileName, int batterySize, String osType){
		super(mobileName,batterySize,osType);
	}
	
	@Override
	public void operate(int time) {
		int useBattery;
		useBattery = super.getBatterySize() - (time * 10);
		super.setBatterySize(useBattery);
	}
	
	@Override
	public void charge(int time) {
		int chargeBattery;
		chargeBattery = super.getBatterySize() + (time * 10);
		super.setBatterySize(chargeBattery);
	}
	
}
