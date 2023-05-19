package springrest.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.Message;

@RestController
public class ResponseEntityController {
    @GetMapping("/success")
    public ResponseEntity successMessage(){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping(value="/serverError", produces = "application/json")
    public ResponseEntity serverErrorMessage(){
        Message message = Message.builder()
                .msg1("둘리")
                .msg2("또치")
                .msg3("도우너")
                .build();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/onlystatus")
    public ResponseEntity onlyStatus(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/header")
    public ResponseEntity header(){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("AUTHCODE","xxxxxxx");
        header.add("TOKEN", "xxxxxx");
        return new ResponseEntity(header, HttpStatus.OK);
    }
}
