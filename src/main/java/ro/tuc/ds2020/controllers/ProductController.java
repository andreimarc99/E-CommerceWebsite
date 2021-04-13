package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.tuc.ds2020.dtos._builders.ProductBuilder;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductWithImageDTO;
import ro.tuc.ds2020.dtos.productDTOs.SimpleProductDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsWithCategoriesDTO;
import ro.tuc.ds2020.entities.Image;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.services.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> productDTOS = productService.findAll();
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<ProductWithImageDTO>> getAllProducts() {
        List<ProductWithImageDTO> productWithImageDTOS = productService.getAllProducts();
        return new ResponseEntity<>(productWithImageDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{productId}")
    public ResponseEntity<ProductWithImageDTO> getProductById(@PathVariable Long productId) {
        ProductWithImageDTO productWithImageDTO = productService.getProductById(productId);
        return new ResponseEntity<>(productWithImageDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertProduct(@RequestBody ProductDTO productDTO) {
        Long insertedProductId;
        try {
            insertedProductId = productService.insertProduct(productDTO);
            return new ResponseEntity<>(insertedProductId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Long> insertProductWithImage(@RequestPart("file") MultipartFile file, @RequestPart("product") SimpleProductDTO product,
                                                       @RequestPart("specs") SpecsWithCategoriesDTO specs) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Image image = new Image(fileName, file.getContentType(), file.getBytes());

        ProductWithImageDTO newProduct = ProductBuilder.toProductWithImageDTO(product, specs, image);
        Long savedProductId;
        try {
            savedProductId= productService.insertProduct(newProduct, specs);
            return new ResponseEntity<>(savedProductId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(productId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(productId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            productService.updateProduct(productDTO);
            return new ResponseEntity<>(productDTO.getProductId(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
