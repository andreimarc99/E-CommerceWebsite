package ro.tuc.ds2020.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
