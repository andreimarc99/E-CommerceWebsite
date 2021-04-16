package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.FavoriteProducts;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface FavoriteProductsRepository extends JpaRepository<FavoriteProducts, Long> {

    @Query("select fp from FavoriteProducts fp inner join Customer c on fp.customer.user.username = c.user.username and c.user.username = :username")
    public Optional<FavoriteProducts> getFavoriteProductsByUsername(@Param("username") String username);
}
