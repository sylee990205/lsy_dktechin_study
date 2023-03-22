package day13;
class Tour  {
   enum Season{ //필요에 의하여 클래스 내에 클래스를 정의 할 수 있는데, Enum도 가능
      SPRING, SUMMER, FALL, WINTER;
      
      String getMyName() {
    	  return "enum 입니당";
      }
   }
}
public class EnumTest3 {
   public static void main(String args[]) {
      Tour.Season day[] = Tour.Season.values();
      for(Tour.Season value  : day)
         System.out.println(value); 
      Tour.Season season = Tour.Season.valueOf("SUMMER"); //Tour 클래스 내의 Season임을 명시해야함
      System.out.println("Tour.Season.valueOf(\"SUMMER\") : " + season); 
      System.out.println(season.getMyName());      
   }
}





