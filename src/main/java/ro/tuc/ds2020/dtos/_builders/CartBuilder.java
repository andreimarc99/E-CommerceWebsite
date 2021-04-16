package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.cartDTOs.CartDTO;
import ro.tuc.ds2020.entities.Cart;

import java.util.stream.Collectors;

public class CartBuilder {

    public static Cart toCart(CartDTO cartDTO) {
        return new Cart(cartDTO.getCartId(),
                cartDTO.getProducts().stream().map(ProductBuilder::toProduct).collect(Collectors.toList()),
                CustomerBuilder.toCustomer(cartDTO.getCustomer()),
                cartDTO.getFullPrice());
    }

    public static CartDTO toCartDTO(Cart cart) {
        return new CartDTO(cart.getCartId(),
                cart.getProducts().stream().map(ProductBuilder::toProductWithImageDTO).collect(Collectors.toList()),
                CustomerBuilder.toCustomerDTO(cart.getCustomer()),
                cart.getFullPrice());
    }

}
