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

	}
}
