package ro.tuc.ds2020.dtos.voucherDTOs;

import java.util.Date;

public class VoucherDTO {
    private Long voucherId;
    private Date startDate;
    private Date endDate;
    private boolean oneTimeOnly;

    public VoucherDTO(Long voucherId, Date startDate, Date endDate, boolean oneTimeOnly) {
        this.voucherId = voucherId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.oneTimeOnly = oneTimeOnly;
    }

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
}
