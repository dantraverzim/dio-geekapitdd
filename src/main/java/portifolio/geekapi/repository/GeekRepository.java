package portifolio.geekapi.repository;

import portifolio.geekapi.entity.Geek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeekRepository extends JpaRepository<Geek, Long> {
}
