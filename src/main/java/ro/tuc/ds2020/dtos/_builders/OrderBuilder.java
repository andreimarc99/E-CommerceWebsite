package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.orderDTOs.OrderDTO;
import ro.tuc.ds2020.entities.Order;

public class OrderBuilder {

    public static Order toOrder(OrderDTO orderDTO) {
        return new Order(orderDTO.getOrderId(),
                CartBuilder.toCart(orderDTO.getCart()),
                VoucherBuilder.toVoucher(orderDTO.getVoucher()),
                orderDTO.isDelivered(),
                orderDTO.getFinalPrice(),
                AddressBuilder.toAddress(orderDTO.getAddress()));
    }

    public static OrderDTO toOrderDTO(Order order) {
        return new OrderDTO(order.getOrderId(),
                CartBuilder.toCartDTO(order.getCart()),
                VoucherBuilder.toVoucherDTO(order.getVoucher()),
                order.isDelivered(),
                order.getFinalPrice(),
                AddressBuilder.toAddressDTO(order.getAddress()));
    }
}
