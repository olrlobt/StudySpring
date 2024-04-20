package olrlobt.springstudy.nonFk.service;

import olrlobt.springstudy.nonFk.domain.Board;

public interface BoardService {
	Board findBoard(Long boardId);

	void addBoard();

	void deleteBoard(Long boardId);

	void addReply(Long boardId);
}
