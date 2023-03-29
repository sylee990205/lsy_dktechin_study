package day18;

import java.util.Date;

@FunctionalInterface
interface MyFunctionalInterface4 {
	public Date method4();
}

public class LambdaTest8 {
	public static void main(String[] args) {
		MyFunctionalInterface4 fi = () -> {
			return new Date();
		};
		System.out.println(fi.method4());

		fi = () -> {
			return new Date();
		};
		System.out.println(fi.method4());

		fi = () -> new Date();
		System.out.println(fi.method4());

		fi =  Date::new;
		System.out.println(fi.method4());		
	}
}
