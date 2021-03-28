package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.favoriteProductsDTOs.FavoriteProductsDTO;
import ro.tuc.ds2020.dtos.favoriteProductsDTOs.ShortFavoriteProductsDTO;
import ro.tuc.ds2020.entities.FavoriteProducts;
import ro.tuc.ds2020.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

public class FavoriteProductsBuilder {
    public static FavoriteProducts toFavoriteProducts(FavoriteProductsDTO favoriteProductsDTO) {
        return new FavoriteProducts(favoriteProductsDTO.getFavoriteProductsId(),
                favoriteProductsDTO.getCustomer(),
                favoriteProductsDTO.getProducts().stream().map(ProductBuilder::toProduct).collect(Collectors.toList()));
    }

    public static FavoriteProducts toFavoriteProducts(ShortFavoriteProductsDTO shortFavoriteProductsDTO) {
        return new FavoriteProducts(shortFavoriteProductsDTO.getFavoriteProductsId(),
                shortFavoriteProductsDTO.getCustomer());
    }

    public static FavoriteProducts toFavoriteProducts(ShortFavoriteProductsDTO shortFavoriteProductsDTO, List<Product> products) {
        return new FavoriteProducts(shortFavoriteProductsDTO.getFavoriteProductsId(),
                shortFavoriteProductsDTO.getCustomer(),
                products);
    }

    public static FavoriteProductsDTO toFavoriteProductsDTO(FavoriteProducts favoriteProducts) {
        return new FavoriteProductsDTO(favoriteProducts.getFavoriteProductsId(),
                favoriteProducts.getCustomer(),
                favoriteProducts.getProducts().stream().map(ProductBuilder::toProductDTO).collect(Collectors.toList()));
    }

    public static ShortFavoriteProductsDTO toShortFavoriteProductsDTO(FavoriteProducts favoriteProducts) {
        return new ShortFavoriteProductsDTO(favoriteProducts.getFavoriteProductsId(),
                favoriteProducts.getCustomer());
    }
}
