package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
