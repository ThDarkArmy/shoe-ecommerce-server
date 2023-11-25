package tda.darkarmy.sneakerhead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.sneakerhead.model.OrderItem;
import tda.darkarmy.sneakerhead.model.Sneakers;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findBySneakers(Sneakers sneakers);
}
