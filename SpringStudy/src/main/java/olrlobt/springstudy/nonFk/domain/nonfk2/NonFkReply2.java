package olrlobt.springstudy.nonFk.domain.nonfk2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import olrlobt.springstudy.nonFk.dto.ReplyResponse;

@Getter
@Entity
public class NonFkReply2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@ManyToOne(optional = false)
	@JoinColumn(name = "board_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@JsonIgnore
	private NonFkBoard2 board;

	public ReplyResponse toDto(){
		return new ReplyResponse(id);
	}
}
