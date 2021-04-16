package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.favoriteProductsDTOs.FavoriteProductsDTO;
import ro.tuc.ds2020.dtos.favoriteProductsDTOs.ShortFavoriteProductsDTO;
import ro.tuc.ds2020.services.FavoriteProductsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/favorite_products")
public class FavoriteProductsController {

    private final FavoriteProductsService favoriteProductsService;

    @Autowired
    public FavoriteProductsController(FavoriteProductsService favoriteProductsService) {
        this.favoriteProductsService = favoriteProductsService;
    }

    @GetMapping()
    public ResponseEntity<List<FavoriteProductsDTO>> findAll() {
        List<FavoriteProductsDTO> favoriteProductsDTOS = favoriteProductsService.getFavoriteProducts();
        return new ResponseEntity<>(favoriteProductsDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<FavoriteProductsDTO> findFavoriteProductsByUsername(@PathVariable String username) {
        try {
            FavoriteProductsDTO favoriteProductsDTO = favoriteProductsService.getFavoriteProductsByUsername(username);
            return new ResponseEntity<>(favoriteProductsDTO, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Long> insertFavoriteProducts(@RequestBody FavoriteProductsDTO favoriteProductsDTO) {
        Long insertedFavoriteProductsId;
        try {
            insertedFavoriteProductsId = favoriteProductsService.insertFavoriteProducts(favoriteProductsDTO);
            return new ResponseEntity<>(insertedFavoriteProductsId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{favoriteProductsId}")
    public ResponseEntity<Long> deleteFavoriteProducts(@PathVariable Long favoriteProductsId) {
        try {
            favoriteProductsService.deleteFavoriteProducts(favoriteProductsId);
            return new ResponseEntity<>(favoriteProductsId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(favoriteProductsId, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping()
    public ResponseEntity<Long> updateProduct(@RequestBody FavoriteProductsDTO productDTO) {
        try {
            favoriteProductsService.updateProduct(productDTO);
            return new ResponseEntity<>(productDTO.getFavoriteProductsId(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
