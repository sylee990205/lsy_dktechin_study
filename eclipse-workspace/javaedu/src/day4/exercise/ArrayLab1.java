package day4.exercise;

public class ArrayLab1 {

	public static void main(String[] args) {
		int ary[] = new int[10];
		
		for(int e : ary) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		for(int i = 0; i < ary.length ; i++) {
			ary[i] = (i+1) * 10;
		}
		System.out.println("첫 번째 : " + ary[0]);
		System.out.println("마지막 : " + ary[ary.length-1]);
		System.out.println("합 : " + (ary[0]+ary[ary.length-1]));
		
		for(int e : ary) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		for(int i = ary.length-1; i >= 0 ; i--) {
			System.out.print(ary[i] + " ");
		}
		System.out.println();
		
		for(int i = 1; i < ary.length; i+=2) {
			System.out.print(ary[i] + " ");
		}

	}

}

//[ 실습 1 ] 
//
//1. ArrayLab1 이라는 클래스를 하나 만든다.
//2. ary 라는 int 타입의 배열 변수를 선언하고 10개의 엘리먼트를 갖는 배열을 생성하여 대입한다.
//3. 배열의 값들을 하나의 행에 다음 형식으로 출력한다.
//   0 0 0 0 0 0 0 0 0 0
//4. 생성된 배열에 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 을 각각의 element 로 저장한다.
//5. 첫 번째 원소와 마지막 원소만 출력하고 합도 출력한다.
//    첫 번째 : 10
//    마지막 : 100
//    합 : 110
//6. 배열의 값들을 하나의 행에 다음 형식으로 출력한다.
//   10 20 30 40 50 60 70 80 90 100
//7. 배열의 값들을 하나의 행에 다음 형식으로 출력한다.(역순으로)
//   100 90 80 70 60 50 40 30 20 10
//8. 배열의 값들을 하나의 행에 다음 형식으로 출력한다.
//   20 40 60 80 100
