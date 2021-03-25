package ro.tuc.ds2020.dtos.userBanDTOs;

import ro.tuc.ds2020.dtos.userDTOs.UserDTO;

import java.util.Date;

public class UserBanDTO {
    private Long banId;
    private String reason;
    private Date startDate;
    private Date endDate;
    private UserDTO user;

    public UserBanDTO() {}

    public UserBanDTO(Long banId, String reason, Date startDate, Date endDate, UserDTO user) {
        this.banId = banId;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public Long getBanId() {
        return banId;
    }

    public void setBanId(Long banId) {
        this.banId = banId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
