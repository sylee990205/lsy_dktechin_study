//Java Day9 Excercise
package emp;

public class Company {

	public static void main(String[] args) {
		Employee[] emp = new Employee[2];
		
		emp[0] = new Secretary("Duke",1,"Secretary",800);
		emp[1] = new Sales("Tuxi",2,"Sales",1200);
		
		printEmployee(emp,false);
		
		System.out.println("\n[인센티브 100 지급]");
		((Secretary)emp[0]).incentive(100);
		((Sales )emp[1]).incentive(100);
		
		printEmployee(emp,true);
	}
	
	public static void printEmployee(Employee[] emp, boolean isTax) {
		
		if (isTax == false) {
			
			System.out.println("name\tdepartment\tsalary\textrapay");
			System.out.println("------------------------------------------");
			
			for(Employee e : emp) {
				System.out.print(e.getName() + "\t" + e.getDepartment());
				
				if (e instanceof Sales) {
					System.out.print("\t\t" + e.getSalary() +"\t"+ ((Sales)e).getExtraPay() + "\n");
				}
				else
					System.out.print("\t" + e.getSalary() + "\n");
			}
		}
		else
		{
			System.out.println("name\tdepartment\tsalary\ttax\textrapay");
			System.out.println("------------------------------------------------------");
			for(Employee e : emp) {
				System.out.print(e.getName() + "\t" + e.getDepartment());
				if (e instanceof Sales) {
					System.out.print("\t\t" + e.getSalary() +"\t"+ e.tax() + "\t" + ((Sales)e).getExtraPay() + "\n");
				}
				else
					System.out.print("\t" + e.getSalary() + "\t" + e.tax() + "\n");
			}
		}
		
		
	}

}
