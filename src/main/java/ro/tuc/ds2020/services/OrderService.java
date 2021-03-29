package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.OrderBuilder;
import ro.tuc.ds2020.dtos.orderDTOs.OrderDTO;
import ro.tuc.ds2020.entities.Order;
import ro.tuc.ds2020.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> findOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderBuilder::toOrderDTO)
                .collect(Collectors.toList());
    }

    public Long insertOrder(OrderDTO orderDTO) {
        Order order = OrderBuilder.toOrder(orderDTO);
        order = orderRepository.save(order);
        LOGGER.debug("Order with ID {} was inserted in db", order.getOrderId());
        return order.getOrderId();
    }

    public void deleteOrder(Long orderId) throws ResourceNotFoundException {
        Optional<Order> order = orderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new ResourceNotFoundException("Order with id " + orderId + " not found.");
        }
        orderRepository.deleteById(orderId);
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) throws ResourceNotFoundException {
        Optional<Order> order = orderRepository.findById(orderDTO.getOrderId());
        if (!order.isPresent()) {
            throw new ResourceNotFoundException("Order with ID " + orderDTO.getOrderId() + " not found.");
        }
        Order updatedOrder = OrderBuilder.toOrder(orderDTO);
        OrderDTO updatedOrderDTO = OrderBuilder.toOrderDTO(orderRepository.save(updatedOrder));
        return updatedOrderDTO;
    }
}
