package olrlobt.springstudy.nonFk.domain.nonfk2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import olrlobt.springstudy.nonFk.dto.BoardResponse;
import olrlobt.springstudy.nonFk.dto.ReplyResponse;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NonFkBoard2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<NonFkReply2> replies = new ArrayList<>();

	@Setter
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private NonFkUser2 user;

	public BoardResponse toDto() {
		List<ReplyResponse> replyResponses = new ArrayList<>();
		replies.forEach(reply -> replyResponses.add(reply.toDto()));
		return new BoardResponse(id, replyResponses, user.getName());
	}
}
