@Valid의 동작 원리

1. 모든 요청은 프론트 컨트롤러인 디스패처 서블릿을 통해 컨트롤러로 전달
2. 전달 과정에서 컨트롤러 메서드의 객체를 만들어주는 ArgumentResolver가 동작
3. @Valid 역시 ArgumentResolver에 의해 처리된다.

`@RequestBody`는 Json 메세지를 객체로 변환해주는 작업이 ArgumentResolver의 구현체인
`RequestResponseBodyMethodProcessor`가 처리하며, 이 내부에서
`@Valid`로 시작하는 어노테이션이 있을 경우에 유효성 검사를 진행한다.

만약, `@ModelAttribute`를 사용중이라면 `ModelAttributeMethodProcessor`에 의해 @Valid가 처리된다.

그리고 검증에 오류가 있다면 `MethodArgumentNotValidException`가 발생
디스패처 서블릿에 기본으로 등록된 예외 리졸버(Exception Resolver)인 
`DefaultHandlerExceptionResolver`에 의해 400 BadRequest 에러가 발생한다.


이러한 이유로,
@Valid는 기본적으로 컨트롤러에서만 동작하며 기본적으로 다른 계층에서는 검증이 되지 않는다. 
다른 계층에서 파라미터를 검증하기 위해서는 @Validated와 결합해서 사용해야 한다.
