package day10.excercise;
import day5.excercise.MethodLab7;

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
