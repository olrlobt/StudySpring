package olrlobt.springstudy.nonFk.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.Board;
import olrlobt.springstudy.nonFk.domain.Reply;
import olrlobt.springstudy.nonFk.dto.BoardResponse;
import olrlobt.springstudy.nonFk.repository.BoardRepository;
import olrlobt.springstudy.nonFk.repository.ReplyRepository;
import olrlobt.springstudy.nonFk.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	private final UserRepository userRepository;

	@Override
	public BoardResponse findBoard(Long boardId) {
		Board board = boardRepository.findById(boardId).get();
		return board.toDto();
	}

	@Override
	public void addBoard() {
		Board board = new Board();
		board.setUser(userRepository.findById(1L).get());
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}

	@Override
	public void addReply(Long boardId) {
		Board board = boardRepository.findById(boardId).get();

		Reply reply = new Reply();
		reply.setBoard(board);
		replyRepository.save(reply);
	}
}
