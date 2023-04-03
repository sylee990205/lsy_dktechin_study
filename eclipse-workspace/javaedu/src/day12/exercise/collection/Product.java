package day12.exercise.collection;

import java.util.Objects;

public class Product {
	private String productID, productName, productPrice;
	
	public Product(String productID, String productName, String productPrice) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if (o != null && o instanceof Product) {
			if(productID.equals(((Product)o).productID))
				// == 말고 .equals로 비교해야함, String.equals는 이미 오버라이딩 되어있어서 값을 비교
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}
	
	@Override
	public String toString() {	
		return String.format("%-10s%-12s%-10s", productID, productName, productPrice);
	}
	
}
