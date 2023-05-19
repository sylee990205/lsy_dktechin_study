package springrest.exam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FriendRepository repository;

    @GetMapping
    public ResponseEntity list() {
        List<Friend> friends = repository.findAll();
        ResponseEntity<List<Friend>> entity = new ResponseEntity<>(friends, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/{id}")
    public ResponseEntity readById(@PathVariable int id) {
        try {
            Friend friend = repository.findById(id).get();
            ResponseEntity<Friend> entity = new ResponseEntity<>(friend, HttpStatus.OK);
            return entity;
        } catch (NoSuchElementException e) {
            return new ResponseEntity(Map.of("BAD_ID",id), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name")
    public ResponseEntity readByName(@RequestParam String name) {
        List<Friend> friends = repository.findByFname(name);
        System.out.println(name);
        ResponseEntity<List<Friend>> entity = new ResponseEntity<>(friends, HttpStatus.OK);
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("BAD_NAME", name);
        return friends.isEmpty() ?  new ResponseEntity(header, HttpStatus.NOT_FOUND) : entity;
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody Friend friend) {
        try {
            repository.save(friend);
            ResponseEntity<String> entity = new ResponseEntity<>("삽입 완료", HttpStatus.CREATED);
            return entity;
        } catch (Exception e) {
            return new ResponseEntity("데이터 삽입 도중 오류 발생", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Friend friend) {
        try {
            Friend oldFriend = repository.findById(id).get();
            oldFriend.setFname(friend.getFname());
            oldFriend.setFage(friend.getFage());
            ResponseEntity<String> entity = new ResponseEntity<>(HttpStatus.RESET_CONTENT);
            return entity;
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("존재하지 않는 ID값입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("수정 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            Friend friend = repository.findById(id).get();
            repository.delete(friend);

            ResponseEntity<String> entity = new ResponseEntity<>(HttpStatus.RESET_CONTENT);
            return entity;
        } catch (NoSuchElementException e) {
            return new ResponseEntity("존재하지 않는 ID값입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity("삭제 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
