package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductWithImageDTO;
import ro.tuc.ds2020.dtos.productDTOs.SimpleProductDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsWithCategoriesDTO;
import ro.tuc.ds2020.entities.Image;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Specs;

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

    public static Product toProduct(ProductWithImageDTO productDTO) {
        return new Product(productDTO.getProductId(),
                SpecsBuilder.toSpecs(productDTO.getSpecs()),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                productDTO.getStock(),
                productDTO.getNumberSold(),
                productDTO.getImage());
    }

    public static Product toProduct(ProductWithImageDTO productDTO, Specs specs) {
        return new Product(productDTO.getProductId(),
                specs,
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                productDTO.getStock(),
                productDTO.getNumberSold(),
                productDTO.getImage());
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

    public static ProductWithImageDTO toProductWithImageDTO(Product product) {
        return new ProductWithImageDTO(product.getProductId(),
                SpecsBuilder.toSpecsWithCategoriesDTO(product.getSpecs()),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock(),
                product.getNumberSold(),
                product.getImage());
    }
    public static ProductWithImageDTO toProductWithImageDTO(SimpleProductDTO product, SpecsWithCategoriesDTO specs, Image image) {
        return new ProductWithImageDTO(product.getProductId(),
                specs,
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock(),
                product.getNumberSold(),
                image);
    }
}
