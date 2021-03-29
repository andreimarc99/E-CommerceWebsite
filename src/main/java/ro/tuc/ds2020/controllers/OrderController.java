package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.orderDTOs.OrderDTO;
import ro.tuc.ds2020.services.OrderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> orderDTOS = orderService.findOrders();
        return new ResponseEntity<>(orderDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertOrder(@RequestBody OrderDTO orderDTO) {
        Long insertedOrderId;
        try {
            insertedOrderId = orderService.insertOrder(orderDTO);
            return new ResponseEntity<>(insertedOrderId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Long> deleteOrder(@PathVariable Long orderId) {
        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(orderId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(orderId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateOrder(@RequestBody OrderDTO orderDTO) {
        try {
            orderService.updateOrder(orderDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
