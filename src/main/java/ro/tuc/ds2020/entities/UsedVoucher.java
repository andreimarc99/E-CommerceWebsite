package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name="used_vouchers")
public class UsedVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usedVoucherId", nullable = false)
    private Long usedVoucherId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voucherId")
    private Voucher voucher;

    public UsedVoucher() {}

    public UsedVoucher(Long usedVoucherId, Customer customer, Voucher voucher) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
