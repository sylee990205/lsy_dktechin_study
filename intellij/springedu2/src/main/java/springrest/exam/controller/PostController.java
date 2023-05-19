package springrest.exam.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.dto.MemberDTO;


@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "안녕? POST 방식 요청 했네~~~";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
