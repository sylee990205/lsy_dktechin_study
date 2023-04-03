package day6.exercise;

class Product { 
	private String name; //보통 private를 설정한 후 외부에서 멤버변수에 접근하지 못하게 한다.
	private int balance; 
	private int price;
	
	Product() {
		name = "듀크인형";
		balance = 5;
		price = 10000;
	}
	
	Product(String name, int balance, int price) { //그리고 생성자를 통해서만 접근이 가능하도록 함.
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
	
	String getName() { //이런 get이 붙은 메소드를 getter 메소드 라고 함
		return name;
	}
	
	int getBalance() {
		return balance;
	}
	
	int getPrice() {
		return price;
	}
}

public class ProductTest {

	public static void main(String[] args) {
		Product[] products = new Product[5];
		products[0] = new Product("춘식이 인형",3,25000);
		products[1] = new Product("어피치 인형",8,25000);
		products[2] = new Product("라이언 인형",10,27000);
		products[3] = new Product("무지 인형",15,24000);
		products[4] = new Product();
		
		for(int i = 0; i < products.length; i++) {
			System.out.printf("상품명: %s, 재고량: %d, 가격: %,d원\n",products[i].getName(),products[i].getBalance(),products[i].getPrice());
		}
	}

}
