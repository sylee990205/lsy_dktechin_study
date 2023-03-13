package day6.excercise;

class Product {
	String name;
	int balance;
	int price;
	
	Product() {
		name = "듀크인형";
		balance = 5;
		price = 10000;
	}
	
	Product(String name, int balance, int price) {
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
	
	String getName() {
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
			System.out.printf("상품명: %s, 재고량: %d, 가격: %,d원\n",products[i].name,products[i].balance,products[i].price);
		}
	}

}
