package study.studyspring;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.studyspring.repository.MemberRepository;
import study.studyspring.service.MemberService;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//        return
//    }


}
