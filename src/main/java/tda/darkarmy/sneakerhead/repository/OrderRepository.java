package tda.darkarmy.sneakerhead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.sneakerhead.model.Orders;
import tda.darkarmy.sneakerhead.model.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUser(User user);
}
