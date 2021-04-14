package ro.tuc.ds2020.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Product;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p inner join Specs s on p.specs.specsId = s.specsId join Category c on c.categoryId in (select categoryId from s.categories) and c.categoryId=:categoryId")
    public List<Product> getProductsByCategoryId(@Param("categoryId") Long categoryId);
}
