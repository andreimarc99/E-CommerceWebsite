package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucherId", nullable = false)
    private Long voucherId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "one_time_only", nullable = false)
    private boolean oneTimeOnly;

    @OneToMany(mappedBy = "voucher")
    private List<UsedVoucher> usedVoucherList = new ArrayList<>();

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
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

    public boolean isOneTimeOnly() {
        return oneTimeOnly;
    }

    public void setOneTimeOnly(boolean oneTimeOnly) {
        this.oneTimeOnly = oneTimeOnly;
    }

    public List<UsedVoucher> getUsedVoucherList() {
        return usedVoucherList;
    }

    public void setUsedVoucherList(List<UsedVoucher> usedVoucherList) {
        this.usedVoucherList = usedVoucherList;
    }
}
