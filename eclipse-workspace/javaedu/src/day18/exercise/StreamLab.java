package day18.exercise;

import java.util.Arrays;

class Trainee {
	private final String name;
    private final boolean isMale; // 성별
    private final int hak; // 학년
    private final int ban; // 반
    private final int score;	    

    public Trainee(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public boolean isMale() {
		return isMale;
	}
	public int getHak() {
		return hak;
	}
	public int getBan() {
		return ban;
	}
	public int getScore() {
		return score;
	}
	public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }
}
public class StreamLab {	
   public static void main(String args[]) {		
		Trainee[] sa = new Trainee[]{
	                new Trainee("나자바", true, 1, 1, 300),
	                new Trainee("김지미", false, 1, 1, 250),
	                new Trainee("김자바", true, 1, 1, 200),
	                new Trainee("이지미", false, 1, 2, 150),
	                new Trainee("남자바", true, 1, 2, 100),
	                new Trainee("안지미", false, 1, 2, 50),
	                new Trainee("황지미", false, 1, 3, 100),
	                new Trainee("강지미", false, 1, 3, 150),
	                new Trainee("이자바", true, 1, 3, 200),
	                new Trainee("나자바", true, 2, 1, 300),
	                new Trainee("김지미", false, 2, 1, 250),
	                new Trainee("김자바", true, 2, 1, 200),
	                new Trainee("이지미", false, 2, 2, 150),
	                new Trainee("남자바", true, 2, 2, 100),
	                new Trainee("안지미", false, 2, 2, 50),
	                new Trainee("황지미", false, 2, 3, 100),
	                new Trainee("강지미", false, 2, 3, 150),
	                new Trainee("이자바", true, 2, 3, 200)
	        };
		// (1) Trainee 객체들을 화면에 출력한다.
		System.out.println("(1) Trainee 객체들을 화면에 출력한다.");
		Arrays.stream(sa).forEach(System.out :: println);
		
		// (2) 성적이 높은 순으로 Trainee 객체들을 화면에 출력한다.
		System.out.println("\n(2) 성적이 높은 순으로 Trainee 객체들을 화면에 출력한다.");
		Arrays.stream(sa).sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore())).forEach(System.out :: println);
		
		// (3) 성적이 200 이상인 Trainee 객체들을 화면에 출력한다.
		System.out.println("\n(3) 성적이 200 이상인 Trainee 객체들을 화면에 출력한다.");
		Arrays.stream(sa).filter(s -> s.getScore() >= 200).forEach(System.out :: println);
				
		// (4) 성적이 200 이상인 수강생들의 인원을 출력한다.
		System.out.println("\n(4) 성적이 200 이상인 수강생들의 인원을 출력한다.");
		long count1 = Arrays.stream(sa).filter(s -> s.getScore() >= 200).count();
		System.out.println(count1);
		
		// (5) 남학생의 Trainee 객체들을 화면에 출력한다.
		System.out.println("\n(5) 남학생의 Trainee 객체들을 화면에 출력한다.");
		Arrays.stream(sa).filter(s -> s.isMale()).forEach(System.out :: println);
		
		// (6) 남학생의 인원을 출력한다.
		System.out.println("\n(6) 남학생의 인원을 출력한다.");
		long count2 = Arrays.stream(sa).filter(s -> s.isMale()).count();
		System.out.println(count2);
		
		// (7) 모든 학생들의 스코어만 출력한다.
		System.out.println("\n(7) 모든 학생들의 스코어만 출력한다.");
		Arrays.stream(sa).forEach(p -> System.out.println(p.getScore()));
		
		// (8) 모든 학생들의 스코어 합을 출력한다.
		System.out.println("\n(8) 모든 학생들의 스코어 합을 출력한다.");
		long sum = Arrays.stream(sa).mapToInt(value -> value.getScore()).sum();
		System.out.println(sum);
		
		System.out.println(Arrays.stream(sa).map(s -> s.getScore()).reduce(0, Integer::sum));
		
   }	
}