package day3.exercise.exam3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class GreetingTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("day3/exercise/exam3.xml");

        Greeting greeting;
        LocalDateTime time = factory.getBean("time", LocalDateTime.class);
        int hour = time.getHour();
        if (hour >= 6 && hour < 12) {
            greeting = factory.getBean("morningGreet", Greeting.class);
        } else if (hour >= 12 && hour < 17) {
            greeting = factory.getBean("afternoonGreet", Greeting.class);
        } else if (hour >= 17 && hour < 22) {
            greeting = factory.getBean("eveningGreet", Greeting.class);
        } else {
            greeting = factory.getBean("nightGreet", Greeting.class);
        }
        greeting.greet();
        ((ClassPathXmlApplicationContext)factory).close();
    }

}
