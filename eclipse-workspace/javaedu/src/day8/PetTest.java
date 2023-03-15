package day8;


abstract class Pet {
	public abstract void petSound(); //미완성

	public void sleep() {
		System.out.println("Zzz");
	}
}
class Dog extends Pet{
	public void petSound() { //public 지정 필수, 상속 받을 땐 제어자 범위를 좁힐 수 없다
		System.out.println("멍멍!!");
	}
}
class Cat extends Pet{
	public void petSound() {
		System.out.println("야옹~~");
	}
}
public class PetTest {
	public static void main(String[] args) {
		actionPet(new Dog());
		actionPet(new Cat());		
	}	
	static void actionPet(Pet obj) {
		obj.petSound();
		obj.sleep();		
	}
}