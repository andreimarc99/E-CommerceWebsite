package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.entities.Product;

public class ProductBuilder {

    public static Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.getProductId(),
                SpecsBuilder.toSpecs(productDTO.getSpecs()),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                productDTO.getStock(),
                productDTO.getNumberSold());
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getProductId(),
                SpecsBuilder.toSpecsWithCategoriesDTO(product.getSpecs()),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock(),
                product.getNumberSold());
    }
}
