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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "voucherId")
    private Voucher voucher;

    @Column(name = "delivered", nullable = false)
    private boolean delivered;

    @Column(name = "finalPrice", nullable = false)
    private Float finalPrice;

    public Order() {}

    public Order(Long orderId, Cart cart, Voucher voucher, boolean delivered, Float finalPrice) {
        this.orderId = orderId;
        this.cart = cart;
        this.voucher = voucher;
        this.delivered = delivered;
        this.finalPrice = finalPrice;
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
}
