package portifolio.geekapi.repository;

import portifolio.geekapi.entity.Geek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeekRepository extends JpaRepository<Geek, Long> {

    Optional<Geek> findByName(String geekName);
}
