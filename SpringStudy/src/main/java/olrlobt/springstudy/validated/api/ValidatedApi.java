package olrlobt.springstudy.validated.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Min;
import olrlobt.springstudy.validated.domain.AdminValidationGroup;
import olrlobt.springstudy.validated.domain.UserRequest;
import olrlobt.springstudy.validated.domain.UserValidationGroup;

@RestController
@Validated // Validated를 붙이고 @Valid를 수행한다.
public class ValidatedApi {

	@GetMapping("/api/validated/{id}")
	public String find(@PathVariable @Min(1)  Long id) {
		// id 값이 0 이하면
		// ConstraintViolationException
		return "ok";
	}

	@PostMapping("/api/validated/user")
	public String validatedGroup1(@RequestBody @Validated(UserValidationGroup.class) UserRequest request) {
		return "ok";
	}

	@PostMapping("/api/validated/admin")
	public String validatedGroup2(@RequestBody @Validated(AdminValidationGroup.class) UserRequest request) {
		return "ok";
	}
}
