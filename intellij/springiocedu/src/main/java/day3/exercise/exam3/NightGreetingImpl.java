package day3.exercise.exam3;

import org.springframework.stereotype.Component;

@Component("nightGreet")
public class NightGreetingImpl implements Greeting {
    @Override
    public void greet() {
        System.out.println("안녕히 주무세요.");
    }
}
