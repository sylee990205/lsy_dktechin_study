package day11;

public class CharacterTest {

	public static void main(String[] args) {
		System.out.println(Character.toLowerCase('A')); //소문자로 a
		System.out.println(Character.toUpperCase('a')); //대문자로 A
		System.out.println(Character.isDigit('A')); // 숫자인지 false
		System.out.println(Character.isDigit('1')); // 숫자인지 true
		System.out.println(Character.isLowerCase('A')); // 소문자인지 false
		System.out.println(Character.isUpperCase('A'));	// 대문자인지 true
		System.out.println(Character.isSpaceChar(' '));	 //공백문자인지 true
	}
}
