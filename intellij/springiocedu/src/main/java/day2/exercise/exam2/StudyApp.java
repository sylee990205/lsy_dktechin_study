package day2.exercise.exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("day2/exercise/bean2.xml");
        Student[] students = new Student[3];
        students[0] = factory.getBean("st1", Student.class);
        students[1] = factory.getBean("st2", Student.class);
        students[2] = factory.getBean("st3", Student.class);

        for (Student s: students) {
            if(s.getMyHomework().getHomeworkName().equals("수학"))
                System.out.printf("%s는 %s을 학습합니다.\n",s.getName(), s.getMyHomework().getHomeworkName());
            else
                System.out.printf("%s는 %s를 학습합니다.\n",s.getName(), s.getMyHomework().getHomeworkName());
        }
        ((ClassPathXmlApplicationContext)factory).close();
    }

}
