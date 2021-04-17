package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Customer;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.user.username = :username")
    public Optional<Customer> getCustomerByUsername(@Param("username") String username);
}
