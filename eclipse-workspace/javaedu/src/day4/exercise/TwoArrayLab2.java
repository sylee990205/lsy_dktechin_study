package day4.exercise;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		char[][] cTwoArray = {
								{'B','C','A','A'},
								{'C','C','B','B'},
								{'D','A','A','D'}
							};
		int[] count = new int[4];
		
		
		for(int i = 0; i < cTwoArray.length ; i++) {
			for(int j = 0; j < cTwoArray[i].length; j++) {
				count[cTwoArray[i][j]- 65] += 1; 
				
				// 이중 포문을 돌리면서 이미 해당 배열의 칸에 어떤 값이 들어가있는지를 알 수 있음
				// 값을 사용해서 그 값이 만약 B라면 ASCII 66에 해당하고 이는 count 배열 index 1에 들어감
				// 따라서 ASCII 'A'에 해당하는 65를 빼주면 66 - 65 = 1 count index 1의 위치에 1을 추가할 수 있음
				// 배열의 인덱스에 i나 j말고 뽑아온 값을 사용할 수 있음을 생각하자
				// if 사용해도 됐나부다...ㅎ
				
//				if (cTwoArray[i][j] == 'A')
//					count[0] += 1;
//				else if (cTwoArray[i][j] == 'B')
//					count[1] += 1;
//				else if (cTwoArray[i][j] == 'C')
//					count[2] += 1;
//				else if (cTwoArray[i][j] == 'D')
//					count[3] += 1;
			}
		}
		
		for(int i = 0; i < count.length; i++) {
			System.out.println((char)('A' + i) + " 는 " + count[i] + "개 입니다.");
		}

	}

}

//[ 실습 2 ]
//1. TwoArrayLab2 라는 클래스를 만든다.
//2. 다음의 내용대로 char 타입의 2차원 배열을 생성한다.
// 
//         'B', 'C', 'A', 'A'
//         'C', 'C', 'B', 'B'
//         'D', 'A', 'A', 'D'
//
//3. 4개의 원소를 갖는 int 타입의 배열을 생성한다.
//    첫번째 원소에는 'A' 문자의 개수    
//    두번째 원소에는 'B' 문자의 개수    
//    세번째 원소에는 'C' 문자의 개수    
//    네번째 원소에는 'D' 문자의 개수    
//    를 저장한다.
//
//4. 출력형식
//    A 는 x개 입니다.
//    B 는 x개 입니다.
//    C 는 x개 입니다.
//    D 는 x개 입니다.	
