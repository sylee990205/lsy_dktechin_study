package day10;
public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		} 
//		catch (Exception e) {
//			System.out.println("오류 발생!");
//		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		} catch (ArithmeticException e) {
		 System.out.println(e.getMessage());
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
			return; //프로그램 종료 - 메인메소드에서의 return - JVM으로 되돌아감
		} catch (NumberFormatException e) {
			e.printStackTrace(); // 밑에서 위로 읽어야함 , 메모리에 쌓인 활동을 출력
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
		}  
		finally {
			System.out.println("항상 수행!!");
		}
		System.out.println("수행종료");
	}
}
