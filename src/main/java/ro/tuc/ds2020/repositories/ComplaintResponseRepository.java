package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.ComplaintResponse;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface ComplaintResponseRepository extends JpaRepository<ComplaintResponse, Long> {

    @Query("select cr from ComplaintResponse cr inner join Complaint c on cr.complaint.complaintId = c.complaintId and c.complaintId = :complaintId")
    public Optional<ComplaintResponse> findComplaintResponseByComplaintId(@Param(value = "complaintId") Long complaintId);
}
