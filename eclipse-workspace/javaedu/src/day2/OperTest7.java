package day2;

public class OperTest7 {

	public static void main(String[] args) {
		int su1=10;
		
		System.out.println(su1);  // 
		int su2 = ++su1;
		System.out.println(su1);  // 
		System.out.println(su2); // 
		int su3 = su1++;
		System.out.println(su1);  // 
		System.out.println(su3); // 
		System.out.println(su2); // 
		
		System.out.println(++su2);  // 
		System.out.println(++su2);  //  
		System.out.println(++su2);  //  
		System.out.println(su2++);  //  
		System.out.println(su2++);  //  
		
		su2++;
		++su2;
		System.out.println(su2);  // 
			
	}

}
