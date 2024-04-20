package olrlobt.springstudy.nonFk.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import olrlobt.springstudy.nonFk.dto.BoardResponse;
import olrlobt.springstudy.nonFk.dto.ReplyResponse;

@Getter
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Reply> replies = new ArrayList<>();

	@Setter
	@ManyToOne
	private User user;

	public BoardResponse toDto() {
		List<ReplyResponse> replyResponses = new ArrayList<>();
		replies.forEach(reply -> replyResponses.add(reply.toDto()));
		return new BoardResponse(id, replyResponses, user.getName());
	}
}
