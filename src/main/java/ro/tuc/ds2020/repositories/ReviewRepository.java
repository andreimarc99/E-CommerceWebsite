package ro.tuc.ds2020.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Review;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r inner join Product p on p.productId = r.product.productId and p.productId=:productId")
    public List<Review> getReviewByProductId(@Param("productId") Long productId);
}
