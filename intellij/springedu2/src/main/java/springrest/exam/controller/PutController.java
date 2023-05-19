package springrest.exam.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value = "/default")
    // 기존의 데이터를 변경하는 기능
    public String putMethod() {
        return "안녕? PUT 방식 요청 했네~~~";
    }

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDto) {
        return memberDto.toString();
    }


    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDto) {
        return memberDto;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDto) {
        return ResponseEntity
            .status(HttpStatus.ACCEPTED) // 요청을 받았다라는 의미, 변경에 관련한 status는 아직 없음
            .body(memberDto);
    }
}