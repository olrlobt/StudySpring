package study.studyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.studyspring.service.MemberService;
import study.studyspring.service.SpringConfig;

@SpringBootApplication
public class StudySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudySpringApplication.class, args);

		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		final MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		final MemberService memberService2 = applicationContext.getBean("memberService", MemberService.class);
		System.out.println(memberService);
		System.out.println(memberService2);
		System.out.println(applicationContext.isSingleton("memberService"));

	}
}
