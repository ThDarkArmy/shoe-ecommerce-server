package tda.darkarmy.sneakerhead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.sneakerhead.model.CartItem;
import tda.darkarmy.sneakerhead.model.Sneakers;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findBySneakers(Sneakers sneakers);

}
