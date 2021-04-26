package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne(optional = true)
    @JoinColumn(name = "voucherId", nullable = true)
    private Voucher voucher;

    @Column(name = "delivered", nullable = false)
    private boolean delivered;

    @Column(name = "finalPrice", nullable = false)
    private Float finalPrice;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "addressId")
    private Address address;

    public Order() {}

    public Order(Long orderId, Cart cart, Voucher voucher, boolean delivered, Float finalPrice, Address address) {
        this.orderId = orderId;
        this.cart = cart;
        this.voucher = voucher;
        this.delivered = delivered;
        this.finalPrice = finalPrice;
        this.address = address;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
