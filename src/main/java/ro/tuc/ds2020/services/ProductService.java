package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.ProductBuilder;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductBuilder::toProductDTO)
                .collect(Collectors.toList());
    }

    public Long insertProduct(ProductDTO productDTO) {
        Product product = ProductBuilder.toProduct(productDTO);
        product = productRepository.save(product);
        LOGGER.debug("Product with id {} was inserted in db", product.getProductId());
        return product.getProductId();
    }

    public void deleteProduct(Long productId) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("Product with id " + productId + " not found.");
        }
        productRepository.deleteById(productId);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(productDTO.getProductId());
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("Product with id " + productDTO.getProductId() + " not found.");
        }
        Product updatedProduct = ProductBuilder.toProduct(productDTO);
        ProductDTO updatedProductDTO = ProductBuilder.toProductDTO(productRepository.save(updatedProduct));
        return updatedProductDTO;
    }
}
