package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Address;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a join User u on a.user.username = u.username and u.username = :username")
    public List<Address> getAddressesByUsername(@Param("username") String username);
}
