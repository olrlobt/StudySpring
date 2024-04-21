package olrlobt.springstudy.nonFk.service.nonfk2;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.Board;
import olrlobt.springstudy.nonFk.domain.Reply;
import olrlobt.springstudy.nonFk.domain.nonfk2.NonFkBoard2;
import olrlobt.springstudy.nonFk.domain.nonfk2.NonFkReply2;
import olrlobt.springstudy.nonFk.dto.BoardResponse;
import olrlobt.springstudy.nonFk.repository.nonfk2.NonFkBoardRepository2;
import olrlobt.springstudy.nonFk.repository.nonfk2.NonFkReplyRepository2;
import olrlobt.springstudy.nonFk.repository.nonfk2.NonFkUserRepository2;

@Service
@RequiredArgsConstructor
public class NonFkBoardServiceImpl2 implements NonFkBoardService2 {

	private final NonFkBoardRepository2 boardRepository;
	private final NonFkReplyRepository2 replyRepository;
	private final NonFkUserRepository2 userRepository;

	@Override
	public BoardResponse findBoard(Long boardId) {
		NonFkBoard2 board = boardRepository.findById(boardId).get();
		return board.toDto();
	}

	@Override
	public void addBoard() {
		NonFkBoard2 board = new NonFkBoard2();
		board.setUser(userRepository.findById(1L).get());
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}

	@Override
	public void addReply(Long boardId) {
		NonFkBoard2 board = boardRepository.findById(boardId).get();

		NonFkReply2 reply = new NonFkReply2();
		reply.setBoard(board);
		replyRepository.save(reply);
	}
}
