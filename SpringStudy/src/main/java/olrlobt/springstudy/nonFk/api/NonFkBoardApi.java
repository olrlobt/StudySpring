package olrlobt.springstudy.nonFk.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.nonfk.NonFkBoard;
import olrlobt.springstudy.nonFk.dto.BoardResponse;
import olrlobt.springstudy.nonFk.service.nonfk.NonFkBoardService;

@RestController
@RequiredArgsConstructor
public class NonFkBoardApi {

	private final NonFkBoardService boardService;


	@GetMapping("/non-fk-api/boards/{boardId}")
	public ResponseEntity<BoardResponse> findBoards(@PathVariable Long boardId) {
		return ResponseEntity.ok(boardService.findBoard(boardId));
	}

	@PostMapping("/non-fk-api/boards")
	public ResponseEntity<?> addBoards() {
		boardService.addBoard();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/non-fk-api/boards/{boardId}/replies")
	public ResponseEntity<?> addReplies(@PathVariable Long boardId) {
		boardService.addReply(boardId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/non-fk-api/boards/{boardId}")
	public ResponseEntity<?> deleteBoards(@PathVariable Long boardId) {
		boardService.deleteBoard(boardId);
		return ResponseEntity.ok().build();
	}


}
