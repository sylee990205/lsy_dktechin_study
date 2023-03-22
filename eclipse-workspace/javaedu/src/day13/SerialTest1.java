package day13;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
public class SerialTest1 {
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos = 
    		  new FileOutputStream("c:/iotest/test1.ser"); 
      ObjectOutputStream oos = 
    		  new ObjectOutputStream(fos); // 생성자를 통해서 전달한 FileOutputStream 객체의 file로 출력
      oos.writeObject(new Date());
      Thread.sleep(3000);
      oos.writeObject(new Date());      
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



