package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_ban")
public class UserBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banId", nullable = false)
    private Long banId;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
