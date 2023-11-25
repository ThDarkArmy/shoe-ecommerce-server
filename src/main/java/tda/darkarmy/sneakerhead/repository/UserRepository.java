package tda.darkarmy.sneakerhead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.sneakerhead.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
