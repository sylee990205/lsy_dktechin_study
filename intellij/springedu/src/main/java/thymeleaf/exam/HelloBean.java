package thymeleaf.exam;

import org.springframework.stereotype.Component;

@Component("unico")
class HelloBean {
    public String hello(String data) {
        return "안녕? " + data;
    }
}
