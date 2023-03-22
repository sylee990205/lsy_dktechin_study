package day13;
public class EnumTest5 {
   public static void main(String args[]) {      
      SeasonInit input = SeasonInit.FALL;
      switch(input) {
	     case SPRING : // case 절에 상수로 사용할 때는 열거타입 명은 제거
            System.out.println(input.returnName());
            break;
         case SUMMER :
            System.out.println(input.returnName());
            break;
         case FALL :
            System.out.println(input.returnName());
            break;
         case WINTER :
            System.out.println(input.returnName());
            break;
      }    
   }
}
