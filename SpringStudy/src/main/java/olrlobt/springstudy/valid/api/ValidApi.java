package olrlobt.springstudy.valid.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import olrlobt.springstudy.valid.domain.UserRequest;
import olrlobt.springstudy.valid.domain.UserRequest2;

@Slf4j
@RestController
public class ValidApi {

	@PostMapping("/api/valid")
	public ResponseEntity<?> valid(@Valid @RequestBody UserRequest userRequest) {
		// 예외가 발생하지 않는다.
		return ResponseEntity.ok().build();
	}

	@PostMapping("/api/valid2")
	public ResponseEntity<?> valid2(@Valid @RequestBody UserRequest2 userRequest2) {
		// 예외가 발생한다.
		// MethodArgumentNotValidException
		return ResponseEntity.ok().build();
	}
}
