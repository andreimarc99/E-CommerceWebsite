package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Complaint;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query("select c from Complaint c inner join Customer cust on c.customer.user.username = cust.user.username and cust.user.username = :username")
    public List<Complaint> getComplaintsByUsername(@Param(value = "username") String username);
}
