package day2;

public class OperTest8 {
	public static void main(String[] args) {
		int iv = 100;
		char cv = (char)iv; //r-value type의 크기가 더 크기에 강제 형 변환
		double dv = iv; //l-value type의 크기가 더 커서 자동 형 변환
		//boolean bv = (boolean)iv; boolean type은 변환 x
		
        System.out.println(iv);
        System.out.println(cv);
        System.out.println(dv);
	}
}
