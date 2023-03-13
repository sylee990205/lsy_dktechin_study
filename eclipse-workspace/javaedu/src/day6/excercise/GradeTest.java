package day6.excercise;
import java.util.Scanner;
import day5.excercise.*;

class GradeExpr{
	private int[] jumsu;
		
	GradeExpr(int[] jumsu){
		this.jumsu = jumsu;
	}
	
	double getAverage() {
		return getTotal()/jumsu.length;
	}
	
	int getTotal() {
		int sum = 0;
		for(int e: jumsu)
			sum += e;
		return sum;
	}
	
	int getGoodScore() {
		int max = 0;
		
		for(int e: jumsu) {
			if(e > max)
				max = e;
		}
		
		return max;
	}
	
	int getBadScore() {
		int min = 100;
		
		for(int e: jumsu) {
			if(e < min)
				min = e;
		}
		
		return min;
	}
}

public class GradeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수의 개수를 입력해주세요: ");
		int count = sc.nextInt();
		int score[] = new int[count];
		
		System.out.println();
		for(int i = 0; i < score.length; i++) {
			System.out.print((i+1)+"번째 점수를 입력해주세요: ");
			score[i] = sc.nextInt();
		}
		System.out.print("점수들 : ");
		MethodLab7.printArray(score);
		
		GradeExpr result = new GradeExpr(score);
		
		System.out.printf("\n총점: %d\n", result.getTotal());
		System.out.printf("평균 : %.2f\n", result.getAverage());
		System.out.printf("최고 점수 : %d\n",result.getGoodScore());
		System.out.printf("최저 점수 : %d",result.getBadScore());
		
		sc.close();
	}

}
