package day2.exercise.exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class GreetingTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("day2/exercise/exam1.xml");
        Greeting greeting;
        LocalDateTime time = factory.getBean("time", LocalDateTime.class);
        int hour = time.getHour();
        if (hour >= 6 && hour < 12) {
            greeting = factory.getBean("morningGreet", MorningGreetingImpl.class);
        } else if (hour >= 12 && hour < 17) {
            greeting = factory.getBean("afternoonGreet", AfternoonGreetingImpl.class);
        } else if (hour >= 17 && hour < 22) {
            greeting = factory.getBean("eveningGreet", EveningGreetingImpl.class);
        } else {
            greeting = factory.getBean("nightGreet", NightGreetingImpl.class);
        }
        greeting.greet();
        ((ClassPathXmlApplicationContext)factory).close();
    }



}
