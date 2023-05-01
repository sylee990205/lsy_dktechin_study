package thymeleaf.exam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleaf.exam.User;

@Controller
@RequestMapping("/basic")
public class ThymeleafBasicController {
	
	@GetMapping("/hithymeleaf")
    public String hiThymeleaf(Model model) {
        model.addAttribute("say", "안녕?");
        return "basic/hithymeleaf";
    }
	
	@GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "컨트롤러가 보낸 데이터!");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>spring!</b>");
        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        final HashMap<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }    

    @GetMapping("/basic-objects")
    public String basicObjects(HttpSession session) {
        session.setAttribute("sessionData", "sessionData라는 이름으로 Session Scope 로 보관된 객체");
        return "basic/basic-objects";
    }

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }
    
    @GetMapping("/utility")
    public String utility(Model model) {     
    	model.addAttribute("now",new java.util.Date());
        model.addAttribute("num", 123456789);
        return "basic/utility";
    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "aa");
        model.addAttribute("param2", "bb");
        model.addAttribute("pageno", 1000);
        model.addAttribute("name", "line");
        model.addAttribute("number", 5);
        return "basic/link";
    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring Boot!");
        return "basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring Boot!");
        return "basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "basic/each";
    }

    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("userA", 10));
        list.add(new User("userB", 20));
        list.add(new User("userC", 30));
        model.addAttribute("users", list);
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        addUsers(model);
        return "basic/condition";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring Boot!");
        return "basic/comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        addUsers(model);
        return "basic/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("userA", 10));
        addUsers(model); 
        return "basic/javascript";
    }
    
    @GetMapping("/fragment1")
    public String freg1() {
        return "basic/fragmentMain1";
    }
    
    @GetMapping("/fragment2")
    public String freg2() {
        return "basic/fragmentMain2";
    }

}
