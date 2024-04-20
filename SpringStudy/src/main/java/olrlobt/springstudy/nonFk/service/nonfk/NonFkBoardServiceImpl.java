package olrlobt.springstudy.nonFk.service.nonfk;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.nonfk.NonFkBoard;
import olrlobt.springstudy.nonFk.domain.nonfk.NonFkReply;
import olrlobt.springstudy.nonFk.repository.nonfk.NonFkBoardRepository;
import olrlobt.springstudy.nonFk.repository.nonfk.NonFkReplyRepository;
import olrlobt.springstudy.nonFk.repository.nonfk.NonFkUserRepository;

@Service
@RequiredArgsConstructor
public class NonFkBoardServiceImpl implements NonFkBoardService {

	private final NonFkBoardRepository boardRepository;
	private final NonFkReplyRepository replyRepository;
	private final NonFkUserRepository userRepository;

	@Override
	public NonFkBoard findBoard(Long boardId) {
		return boardRepository.findById(boardId).get();
	}

	@Override
	public void addBoard() {
		NonFkBoard board = new NonFkBoard();
		board.setUserId(1L);
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}

	@Override
	public void addReply(Long boardId) {
		NonFkReply reply = new NonFkReply();
		reply.setBoardId(boardId);
		replyRepository.save(reply);
	}
}
