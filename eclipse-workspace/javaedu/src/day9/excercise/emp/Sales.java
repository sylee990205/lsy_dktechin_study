//Java Day9 Excercise
package day9.excercise.emp;

public class Sales extends Employee implements Bonus {
	public Sales() {
		
	}
	
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	@Override
	public double tax() {
		return super.getSalary() * 0.13;
	}
	
	@Override
	public void incentive(int pay) {
		super.setSalary(super.getSalary() + (int)(pay * 1.2));
	}
	
	public double getExtraPay() {
		return super.getSalary() * 0.03;
	}
}
