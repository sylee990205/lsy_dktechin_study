package day13;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class StepDTO implements Serializable{
	private static final long serialVersionUID = -9060430121447664088L;

	// 만약 직렬화를 하고 싶지 않은 멤버 변수가 있다면
	
	private String stepId;
	transient private String password; // transient 제어자를 사용하여 직렬화 대상에서 제외 시킬 수 있음
										 // 오직 직렬화 할때만 제외됨
										//  역직렬화시에는 기본값을 가짐
	
	private int age;
	transient private int score; 
	public StepDTO(String stepId, String password, int age, int score) {
		super();
		this.stepId = stepId;
		this.password = password;
		this.age = age;
		this.score = score;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

public class SerialTest5 {
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos = 
    		  new FileOutputStream("c:/iotest/test3.ser"); 
      ObjectOutputStream oos = 
    		  new ObjectOutputStream(fos);
      
      StepDTO dto  = new StepDTO("unico", "@12345", 33, 100);
      oos.writeObject(dto);
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



