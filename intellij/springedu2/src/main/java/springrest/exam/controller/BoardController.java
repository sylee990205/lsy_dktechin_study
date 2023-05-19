package springrest.exam.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springrest.exam.domain.Board;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {

	List<Board> boardList = new ArrayList<>();

	public BoardController() {
		Board board = new Board();
		board.setBoardNo(1);
		board.setTitle("아기공룡 둘리 한자대탐험");
		board.setContent("둘리 학습만화 시리즈");
		board.setWriter("김수정");
		board.setRegDate(LocalDateTime.now());

		boardList.add(board);

		board = new Board();

		board.setBoardNo(2);
		board.setTitle("고래 도서관");
		board.setContent("바다 도서관 이야기");
		board.setWriter("지드루");
		board.setRegDate(LocalDateTime.now());

		boardList.add(board);
	}

	@GetMapping
	public ResponseEntity<List<Board>> list() {
		log.info("list");

		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);

		return entity;
	}

	@PostMapping
	public ResponseEntity<String> register(@RequestBody Board board) {
		log.info("register");
		boardList.add(board);
		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 삽입했어용", HttpStatus.OK);

		return entity;
	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		log.info("read");

		Board board = new Board();
		board.setBoardNo(boardNo);
	 	int index = boardList.indexOf(board);
		if (index >= 0)
			 board = boardList.get(index);

		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo) {
		log.info("remove");
		Board board = new Board();
		board.setBoardNo(boardNo);
		boardList.remove(board);

		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 삭제했어용", HttpStatus.OK);

		return entity;
	}

	@PutMapping("/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modify");

		Board board1 = new Board();
		board1.setBoardNo(boardNo);
		int index = boardList.indexOf(board1);
		if (index >= 0)
			board1 = boardList.get(index);
		board1.setWriter(board.getWriter());
		board1.setContent(board.getContent());
		board1.setTitle(board.getTitle());
		board1.setRegDate(board.getRegDate());

		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 수정했어용", HttpStatus.OK);

		return entity;
	}
	
}
