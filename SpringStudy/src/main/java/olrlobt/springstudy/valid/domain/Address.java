package olrlobt.springstudy.valid.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Address {
	@NotBlank
	private String city;

	@NotBlank
	private String zipCode;

}
