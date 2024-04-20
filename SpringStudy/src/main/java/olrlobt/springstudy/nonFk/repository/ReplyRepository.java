package olrlobt.springstudy.nonFk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
