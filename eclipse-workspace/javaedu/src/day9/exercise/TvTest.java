package day9.exercise;

public class TvTest {

	public static void main(String[] args) {
		SaleTV saleTv = new SaleTV(300000,"SALETV-1",40,1);
		RentalTV rentalTv = new RentalTV(100000,"RENTALTV-10",42,1);
		
		saleTv.channelUp();
		saleTv.channelUp();
		
		rentalTv.channelDown();
		rentalTv.channelDown();
		rentalTv.channelDown();
		
		printAllTv(saleTv);
		printAllTv(rentalTv);
		
		printRentalTV(rentalTv);
		
	}
	
	static void printAllTv(TV tv) {
		
		//System.out.printf(tv.toString());
		// 어떤 객체든 출력하라고 하면 그 내용의 toString을 출력하기에 tv만 입력하고 toString은 생략해도 됨
		System.out.print(tv);
		
		if (tv instanceof SaleTV) {
			// ((saleTv)tv) == [SaleTv 변수명 = (SaleTV) tv]
			// 같은 의미, 메모리상에선 다름
			// 뒤의 경우에는 변수가 하나 더 생김 
			((SaleTV)tv).play();
			((SaleTV)tv).sale();
		}
		else {
			((RentalTV)tv).play();
		}
		
		
	}
	
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}

}
