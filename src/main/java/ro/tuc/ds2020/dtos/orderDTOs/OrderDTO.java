package ro.tuc.ds2020.dtos.orderDTOs;

import ro.tuc.ds2020.dtos.addressDTOs.AddressDTO;
import ro.tuc.ds2020.dtos.cartDTOs.CartDTO;
import ro.tuc.ds2020.dtos.voucherDTOs.VoucherDTO;

public class OrderDTO {
    private Long orderId;
    private CartDTO cart;
    private VoucherDTO voucher;
    private boolean delivered;
    private Float finalPrice;
    private AddressDTO address;

    public OrderDTO(Long orderId, CartDTO cart, VoucherDTO voucher, boolean delivered, Float finalPrice, AddressDTO addressDTO) {
        this.orderId = orderId;
        this.cart = cart;
        this.voucher = voucher;
        this.delivered = delivered;
        this.finalPrice = finalPrice;
        this.address = addressDTO;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    public VoucherDTO getVoucher() {
        return voucher;
    }

    public void setVoucher(VoucherDTO voucher) {
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
