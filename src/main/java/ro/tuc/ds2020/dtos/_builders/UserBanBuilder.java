package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.userBanDTOs.UserBanDTO;
import ro.tuc.ds2020.entities.UserBan;

public class UserBanBuilder {
    public static UserBan toUserBan(UserBanDTO userBanDTO) {
        return new UserBan(userBanDTO.getBanId(),
                userBanDTO.getReason(),
                userBanDTO.getStartDate(),
                userBanDTO.getEndDate(),
                UserBuilder.toUser(userBanDTO.getUser()));
    }

    public static UserBanDTO toUserBanDTO(UserBan userBan) {
        return new UserBanDTO(userBan.getBanId(),
                userBan.getReason(),
                userBan.getStartDate(),
                userBan.getEndDate(),
                UserBuilder.toUserDTO(userBan.getUser()));
    }
}
