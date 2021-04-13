package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.ProductBuilder;
import ro.tuc.ds2020.dtos._builders.SpecsBuilder;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductWithImageDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsWithCategoriesDTO;
import ro.tuc.ds2020.entities.Image;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Specs;
import ro.tuc.ds2020.repositories.ImageRepository;
import ro.tuc.ds2020.repositories.ProductRepository;
import ro.tuc.ds2020.repositories.SpecsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final SpecsRepository specsRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, SpecsRepository specsRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.specsRepository = specsRepository;
        this.imageRepository = imageRepository;
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductBuilder::toProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductWithImageDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductBuilder::toProductWithImageDTO)
                .collect(Collectors.toList());
    }

    public ProductWithImageDTO getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("Product with id " + productId + " not found.");
        }
        return ProductBuilder.toProductWithImageDTO(product.get());
    }

    public Long insertProduct(ProductDTO productDTO) {
        Product product = ProductBuilder.toProduct(productDTO);
        product = productRepository.save(product);
        LOGGER.debug("Product with id {} was inserted in db", product.getProductId());
        return product.getProductId();
    }

    public Long insertProduct(ProductWithImageDTO productDTO) {
        Product product = ProductBuilder.toProduct(productDTO);
        product = productRepository.save(product);
        LOGGER.debug("Product with id {} was inserted in db", product.getProductId());
        return product.getProductId();
    }

    public Long insertProduct(ProductWithImageDTO productWithImageDTO, SpecsWithCategoriesDTO specsWithCategoriesDTO) {
        Specs specs = SpecsBuilder.toSpecs(specsWithCategoriesDTO);
        System.out.println("---------------- " + specs.toString() + " ----------------------");
        specs = specsRepository.save(specs);
        Image image = imageRepository.save(productWithImageDTO.getImage());
        productWithImageDTO.setImage(image);

        Product product = ProductBuilder.toProduct(productWithImageDTO, specs);
        System.out.println("-------" + product.toString());
        return productRepository.save(product).getProductId();
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
