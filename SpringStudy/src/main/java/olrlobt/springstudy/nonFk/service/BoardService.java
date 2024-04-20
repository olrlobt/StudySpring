package olrlobt.springstudy.nonFk.service;

import olrlobt.springstudy.nonFk.dto.BoardResponse;

public interface BoardService {
	BoardResponse findBoard(Long boardId);

	void addBoard();

	void deleteBoard(Long boardId);

	void addReply(Long boardId);
}
