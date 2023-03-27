package day16;
import java.util.Date;
class Person {
}
class Worker extends Person {
}
class NewWorker extends Worker {
}
class Student extends Person {
}
class HighStudent extends Student {
}
class MiddleStudent extends Student{
}

class My<T> {
	T obj;
	My(T obj) {
		this.obj = obj;
	}
	public String toString() {
		return obj.getClass().getName()+"객체임";
	}
}
public class WildCardTest {
	static void m1(My<?> p) {
		System.out.println(p);
	}
	static void m2(My<? extends Student> p) {
		System.out.println(p);
	}
	static void m3(My<? super Worker> p) {
		System.out.println(p);
	}
	public static void main(String[] args) {
		m1(new My<Date>(new Date()));
		m1(new My<String>("abc"));
		m1(new My<Integer>(100));
		m1(new My<Person>(new Person()));
		m1(new My<Worker>(new Worker()));
		m1(new My<Student>(new Student()));
		m1(new My<HighStudent>(new HighStudent()));
		m1(new My<MiddleStudent>(new MiddleStudent()));
		System.out.println("-----------------------");
		m2(new My<Student>(new Student()));
		m2(new My<HighStudent>(new HighStudent()));
		m2(new My<MiddleStudent>(new MiddleStudent()));
		//m2(new My<>(100));
		//m2(new My<>(new Person()));
		//m2(new My<>(new Worker()));
		System.out.println("-----------------------");		
		m3(new My<Person>(new Person()));
		m3(new My<Worker>(new Worker()));
		m3(new My<Object>(new Object()));
		//m3(new My<Student>(new Student()));
		//m3(new My<HighStudent>(new HighStudent()));
		//m3(new My<NewWorker>(new NewWorker()));
	}
}
