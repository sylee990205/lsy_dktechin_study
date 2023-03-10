package day5;
public class MethodTest9 {
	public static void main(String[] args) {
		int p1[] = { 20, 10, 14, 30};
		System.out.println("p1 변수의 값 : "+p1); // [I@참조값
		printArray(p1); // 20 10 14 30
		int[] result = updateArray1(p1); // 호출하면서 p1 값을 매개변수로 전달 --> p2 메모리 생성
		printArray(result); 
		printArray(p1);
		System.out.println("-------------------");
		updateArray2(p1);
		printArray(p1);
	}
	
	static void printArray(int[] p2) {
		for(int d : p2)
			System.out.printf("%d ", d);
		System.out.printf("\n");
	}
	
	static int[] updateArray1(int[] p2) { //p2에겐 int 배열 값의 참조값이 전달된다.
		System.out.println("p2 변수의 값 : "+p2); 
		int[] result = new int[p2.length]; // p2에 전달받은 배열의 길이인 새로운 배열 생성
		for(int i=0; i < result.length;i++) // 새로운 배열에 값 복사
			result[i] = p2[i] * 2;
		return result; // 새로운 배열을 만들어 return 하기에 p1 배열에는 변화가 없음
	} //메소드 호출이 종료되면 p2 메모리는 사라짐
	
	
	static void updateArray2(int[] p3) { //int 배열을 argument로 받음
		System.out.println("p3 변수의 값 : "+p3);
		for(int i=0; i < p3.length;i++)
			p3[i] = p3[i] * 2; // argument로 전달된 원본 배열을 변화
	}
	
}








