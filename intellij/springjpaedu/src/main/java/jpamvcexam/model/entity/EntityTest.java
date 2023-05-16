package jpamvcexam.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EntityTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private LocalDateTime  birthday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "EntityTest1 [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}	
}
