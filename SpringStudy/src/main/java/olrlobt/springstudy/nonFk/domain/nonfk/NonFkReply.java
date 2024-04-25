package olrlobt.springstudy.nonFk.domain.nonfk;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import olrlobt.springstudy.nonFk.dto.ReplyResponse;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NonFkReply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	private Long boardId;

	public ReplyResponse toDto(){
		return new ReplyResponse(id);
	}
}
