package day12;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialTest6 {
   public static void main(String[] args) throws Exception{ 
      FileInputStream fis = 
    		  new FileInputStream("c:/iotest/test3.ser"); 
      ObjectInputStream ois = new ObjectInputStream(fis); 
      StepDTO dto = (StepDTO)ois.readObject();
      System.out.println("Student객체 데이터 : ");
      System.out.println(dto.getStepId());
      System.out.println(dto.getPassword());
      System.out.println(dto.getAge());
      System.out.println(dto.getScore());
      ois.close();
      fis.close();
   }
}



