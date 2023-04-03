package day12.exercise.collection;

import java.util.Objects;

public class Product2 implements Comparable<Product2>{
	private String productID, productName;
	private int productPrice;
	
	public Product2(String productID, String productName, int productPrice) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if (o != null && o instanceof Product2) {
			if(productID.equals(((Product2)o).productID))
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
	public int compareTo(Product2 p) {
		if(productPrice < p.productPrice) return 1;
		else if(productPrice == p.productPrice) return 0;
		else return -1;
	}
	
	
	@Override
	public String toString() {	
		return String.format("%-10s%-12s%,d원", productID, productName, productPrice);
	}
	
}
