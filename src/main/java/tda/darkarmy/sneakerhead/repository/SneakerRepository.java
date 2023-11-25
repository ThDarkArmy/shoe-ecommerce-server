package tda.darkarmy.sneakerhead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.sneakerhead.model.Sneakers;
import tda.darkarmy.sneakerhead.model.User;

import java.util.List;

public interface SneakerRepository extends JpaRepository<Sneakers, Long> {
    List<Sneakers> findByUser(User user);
}
