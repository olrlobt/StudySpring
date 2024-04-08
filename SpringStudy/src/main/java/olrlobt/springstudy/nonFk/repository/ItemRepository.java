package olrlobt.springstudy.nonFk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import olrlobt.springstudy.nonFk.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
