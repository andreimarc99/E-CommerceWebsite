package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Cart;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c inner join Customer a on c.customer.user.username = a.user.username and a.user.username = :username")
    public Optional<Cart> getCartByUsername(@Param("username") String username);
}
