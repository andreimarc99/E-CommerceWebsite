package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.cartDTOs.CartDTO;
import ro.tuc.ds2020.services.CartService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public ResponseEntity<List<CartDTO>> findAll() {
        List<CartDTO> cartDTOS = cartService.findCarts();
        return new ResponseEntity<>(cartDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<CartDTO> findCartByUsername(@PathVariable String username) {
        try {
            CartDTO cartDTO = cartService.getCartByUsername(username);
            return new ResponseEntity<>(cartDTO, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Long> insertCart(@RequestBody CartDTO cartDTO) {
        Long insertedCartId;
        try {
            insertedCartId = cartService.insertCart(cartDTO);
            return new ResponseEntity<>(insertedCartId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity<Long> deleteCart(@PathVariable Long cartId) {
        try {
            cartService.deleteCart(cartId);
            return new ResponseEntity<>(cartId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(cartId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateCart(@RequestBody CartDTO cartDTO) {
        try {
            cartService.updateCart(cartDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
