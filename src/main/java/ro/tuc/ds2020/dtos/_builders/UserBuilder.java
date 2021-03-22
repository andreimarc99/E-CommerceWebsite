package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.userDTOs.UserDTO;
import ro.tuc.ds2020.entities.User;

public class UserBuilder {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getCNP(),
                user.getBirthDate(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender());
    }

    public static User toUser(UserDTO user) {
        return new User(user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getCNP(),
                user.getBirthDate(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender());
    }
}
