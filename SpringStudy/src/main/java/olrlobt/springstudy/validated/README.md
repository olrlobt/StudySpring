## @Validated의 동작 원리

`@Validated`는 JSR 표준 기술이 아니며 Spring 프레임워크에서 제공하는 어노테이션이다.


특정 `ArgumentResolver`에 의해 유효성 검사가 진행되던 `@Valid`와 달리,
`@Validated`는 AOP를 기반으로 메소드 요청을 인터셉터하여 처리된다.

1. `@Validated`를 클래스 레벨에 선언하면 해당 클래스에 유효성 검증을 위한 AOP의 어드바이스, 또는 인터셉터(MethodValidationInterceptor)가 등록됨
2. 해당 클래스의 메서드가 호출 될 때, AOP의 포인트 컷으로써 요청을 가로채서 유효성 검증을 진행


따라서, `@Validated`를 사용하면, 컨트롤러, 서비스 레포지토리 등 계층에 무관하게
스프링 빈이라면 유효성 검증을 진행할 수 있다.

이러한 이유로, 유효성 검증에 대한 예외는 `ConstraintViolationException`이다.




## @Validated 유효성 검증 그룹 지정

동일한 클래스에서 요청에 따라 제약조건이 달라질 수 있다.
Spring은 `@Validated`를 통해 제약 조건이 적용될 검증 그룹을 지정할 수 있다.

1. 마커 인터페이스를 간단히 정의한다.
```java
public interface AdminValidationGroup {
}
public interface UserValidationGroup {
}
```


2. Validation에서 groups설정을 해준다.
```java
@Email(groups = UserValidationGroup.class)
private String email;

@NotBlank(groups = {UserValidationGroup.class, AdminValidationGroup.class})
private String password;
```


3. 검증할 파라미터 앞에 @Validated를 사용한다.

```java
@PostMapping("/api/validated/admin")
public String validatedGroup2(@RequestBody @Validated(AdminValidationGroup.class) UserRequest request) {
    return "ok";
}
```

`@Validated`의 그룹 지정 기능은 코드가 복잡해져서 거의 사용되지 않는다.



