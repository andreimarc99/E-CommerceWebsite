package ro.tuc.ds2020.dtos.usedVouchersDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.voucherDTOs.VoucherDTO;

public class UsedVoucherDTO {
    private Long usedVoucherId;
    private CustomerDTO customer;
    private VoucherDTO voucher;

    public UsedVoucherDTO() {}

    public UsedVoucherDTO(Long usedVoucherId, CustomerDTO customer, VoucherDTO voucher) {
        this.usedVoucherId = usedVoucherId;
        this.customer = customer;
        this.voucher = voucher;
    }

    public Long getUsedVoucherId() {
        return usedVoucherId;
    }

    public void setUsedVoucherId(Long usedVoucherId) {
        this.usedVoucherId = usedVoucherId;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public VoucherDTO getVoucher() {
        return voucher;
    }

    public void setVoucher(VoucherDTO voucher) {
        this.voucher = voucher;
    }
}
