package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.CartBuilder;
import ro.tuc.ds2020.dtos.cartDTOs.CartDTO;
import ro.tuc.ds2020.entities.Cart;
import ro.tuc.ds2020.repositories.CartRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartDTO> findCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream()
                .map(CartBuilder::toCartDTO)
                .collect(Collectors.toList());
    }

    public Long insertCart(CartDTO cartDTO) {
        Cart cart = CartBuilder.toCart(cartDTO);
        cart = cartRepository.save(cart);
        LOGGER.debug("Cart with ID {} was inserted in db", cart.getCartId());
        return cart.getCartId();
    }

    public void deleteCart(Long cartId) throws ResourceNotFoundException {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (!cart.isPresent()) {
            throw new ResourceNotFoundException("Cart with id " + cartId + " not found.");
        }
        cartRepository.deleteById(cartId);
    }

    public CartDTO updateCart(CartDTO cartDTO) throws ResourceNotFoundException {
        Optional<Cart> cart = cartRepository.findById(cartDTO.getCartId());
        if (!cart.isPresent()) {
            throw new ResourceNotFoundException("Cart with ID " + cartDTO.getCartId() + " not found.");
        }
        Cart updatedCart = CartBuilder.toCart(cartDTO);
        CartDTO updatedCartDTO = CartBuilder.toCartDTO(cartRepository.save(updatedCart));
        return updatedCartDTO;
    }
}
