package olrlobt.springstudy.nonFk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import olrlobt.springstudy.nonFk.domain.Board;
import olrlobt.springstudy.nonFk.domain.Item;
import olrlobt.springstudy.nonFk.dto.AddBoardRequest;
import olrlobt.springstudy.nonFk.repository.BoardRepository;
import olrlobt.springstudy.nonFk.repository.ItemRepository;
import olrlobt.springstudy.nonFk.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	public Board findBoard(Long boardId){
		return boardRepository.findById(boardId).get();
	}

	public void addBoard(AddBoardRequest request) {
		Board board = new Board();
		List<Item> allById = itemRepository.findAllById(request.getItemIds());
		board.setItems(allById);
		board.setUser(userRepository.findById(1L).get());
		boardRepository.save(board);
	}
}
