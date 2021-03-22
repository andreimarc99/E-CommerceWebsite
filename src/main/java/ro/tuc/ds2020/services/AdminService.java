package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.AdminBuilder;
import ro.tuc.ds2020.dtos.adminDTOs.AdminDTO;
import ro.tuc.ds2020.dtos.adminDTOs.AdminToBeInsertedDTO;
import ro.tuc.ds2020.dtos.userDTOs.UserDTO;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.repositories.AdminRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminDTO> findAll() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(AdminBuilder::toAdminDTO)
                .collect(Collectors.toList());
    }

    public Long insertAdmin(AdminToBeInsertedDTO adminToBeInsertedDTO) {
        Admin admin = AdminBuilder.toAdmin(adminToBeInsertedDTO);
        admin = adminRepository.save(admin);
        LOGGER.debug("Admin with username {} was inserted in db", admin.getUser().getUsername());
        return admin.getAdminId();
    }

    public void deleteAdmin(Long adminId) throws ResourceNotFoundException {
        Optional<Admin> admin = adminRepository.findById(adminId);
        if (!admin.isPresent()) {
            throw new ResourceNotFoundException("Admin with id " + adminId + " not found.");
        }
        adminRepository.deleteById(adminId);
    }

    public AdminDTO updateAdmin(AdminToBeInsertedDTO adminToBeInsertedDTO) throws ResourceNotFoundException {
        Optional<Admin> admin = adminRepository.findById(adminToBeInsertedDTO.getAdminId());
        if (!admin.isPresent()) {
            throw new ResourceNotFoundException("Admin with username " + adminToBeInsertedDTO.getUsername() + " not found.");
        }
        Admin updatedAdmin = AdminBuilder.toAdmin(adminToBeInsertedDTO);
        AdminDTO updatedAdminDTO = AdminBuilder.toAdminDTO(adminRepository.save(updatedAdmin));
        return updatedAdminDTO;
    }
}
