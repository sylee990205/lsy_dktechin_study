package day7;


abstract class Pet {
	public abstract void petSound();

	public void sleep() {
		System.out.println("Zzz");
	}
}
class Dog extends Pet{
	public void petSound() {
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
