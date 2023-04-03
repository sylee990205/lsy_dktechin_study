package day10.exercise;
import day5.exercise.MethodLab7;

public class LottoGame {

	public static void main(String[] args) {
		LottoMachine lotto = new LottoMachine();
		
		lotto.createLottoNums();
		
		try {
			lotto.checkLottoNums();
			
			MethodLab7.printArray(lotto.getNums());
		}
		catch(DuplicateException e){
			System.out.println(e.getMessage());
		}
		

	}

}
