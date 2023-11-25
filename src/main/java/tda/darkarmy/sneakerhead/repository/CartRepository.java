package tda.darkarmy.sneakerhead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.sneakerhead.model.Cart;
import tda.darkarmy.sneakerhead.model.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart findByUser(User user);
}
