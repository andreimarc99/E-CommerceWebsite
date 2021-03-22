package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.adminDTOs.AdminDTO;
import ro.tuc.ds2020.dtos.adminDTOs.AdminToBeInsertedDTO;
import ro.tuc.ds2020.dtos.userDTOs.UserDTO;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.entities.User;

public class AdminBuilder {
    public static AdminDTO toAdminDTO(Admin admin) {
        return new AdminDTO(admin.getAdminId(),
                UserBuilder.toUserDTO(admin.getUser()),
                admin.getSalary(),
                admin.getDateHired());
    }

    public static Admin toAdmin(AdminDTO adminDTO) {
        return new Admin(adminDTO.getAdminId(),
                UserBuilder.toUser(adminDTO.getUser()),
                adminDTO.getSalary(),
                adminDTO.getDateHired());
    }

    public static Admin toAdmin(AdminToBeInsertedDTO adminToBeInsertedDTO) {
        return new Admin(adminToBeInsertedDTO.getAdminId(),
                new User(adminToBeInsertedDTO.getUsername(),
                adminToBeInsertedDTO.getPassword(),
                adminToBeInsertedDTO.getRole(),
                adminToBeInsertedDTO.getCNP(),
                adminToBeInsertedDTO.getBirthDate(),
                adminToBeInsertedDTO.getFirstName(),
                adminToBeInsertedDTO.getLastName(),
                adminToBeInsertedDTO.getGender()),
                adminToBeInsertedDTO.getSalary(),
                adminToBeInsertedDTO.getDateHired());
    }
}
