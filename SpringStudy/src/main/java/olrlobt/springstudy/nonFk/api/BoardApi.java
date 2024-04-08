package olrlobt.springstudy.nonFk.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.Board;
import olrlobt.springstudy.nonFk.dto.AddBoardRequest;
import olrlobt.springstudy.nonFk.service.BoardService;

@RestController
@RequiredArgsConstructor
public class BoardApi {

	private final BoardService boardService;

	@GetMapping("/api/boards/{boardId}")
	public ResponseEntity<Board> findBoards(@PathVariable Long boardId) {
		return ResponseEntity.ok(boardService.findBoard(boardId));
	}

	@PostMapping("/api/boards")
	public ResponseEntity<?> addBoards(@RequestBody AddBoardRequest request) {
		boardService.addBoard(request);
		return ResponseEntity.ok().build();
	}
}
