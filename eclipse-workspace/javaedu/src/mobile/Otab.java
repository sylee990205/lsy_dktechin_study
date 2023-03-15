// java Day8 excercise
package mobile;

public class Otab extends Mobile{
	public Otab(){
		
	}
	
	public Otab(String mobileName, int batterySize, String osType){
		super(mobileName,batterySize,osType);
	}
	
	@Override
	public void operate(int time) {
		int useBattery;
		useBattery = super.getBatterySize() - (time * 12);
		super.setBatterySize(useBattery);
	}
	
	@Override
	public void charge(int time) {
		int chargeBattery;
		chargeBattery = super.getBatterySize() + (time * 8);
		super.setBatterySize(chargeBattery);
	}
}
