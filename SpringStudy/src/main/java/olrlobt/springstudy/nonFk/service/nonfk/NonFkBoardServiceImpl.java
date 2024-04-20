package olrlobt.springstudy.nonFk.service.nonfk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.nonfk.NonFkBoard;
import olrlobt.springstudy.nonFk.domain.nonfk.NonFkReply;
import olrlobt.springstudy.nonFk.domain.nonfk.NonFkUser;
import olrlobt.springstudy.nonFk.dto.BoardResponse;
import olrlobt.springstudy.nonFk.dto.ReplyResponse;
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
	public BoardResponse findBoard(Long boardId) {

		NonFkBoard nonFkBoard = boardRepository.findById(boardId).get();
		List<NonFkReply> allByBoardId = replyRepository.findAllByBoardId(boardId);
		List<ReplyResponse> replyResponses = new ArrayList<>();
		allByBoardId.forEach(nonFkReply -> replyResponses.add(nonFkReply.toDto()));
		NonFkUser nonFkUser = userRepository.findById(nonFkBoard.getUserId()).get();
		return new BoardResponse(nonFkBoard.getId(), replyResponses, nonFkUser.getName());
	}

	@Override
	public void addBoard() {
		NonFkBoard board = new NonFkBoard();
		board.setUserId(1L);
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		List<NonFkReply> allByBoardId = replyRepository.findAllByBoardId(boardId);
		replyRepository.deleteAll(allByBoardId);
		boardRepository.deleteById(boardId);
	}

	@Override
	public void addReply(Long boardId) {
		if(!boardRepository.existsById(boardId)){
			return;
		}
		NonFkReply reply = new NonFkReply();
		reply.setBoardId(boardId);
		replyRepository.save(reply);
	}
}
