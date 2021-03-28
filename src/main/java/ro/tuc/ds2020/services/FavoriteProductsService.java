package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.FavoriteProductsBuilder;
import ro.tuc.ds2020.dtos.favoriteProductsDTOs.FavoriteProductsDTO;
import ro.tuc.ds2020.dtos.favoriteProductsDTOs.ShortFavoriteProductsDTO;
import ro.tuc.ds2020.entities.FavoriteProducts;
import ro.tuc.ds2020.repositories.FavoriteProductsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteProductsService {

    private final FavoriteProductsRepository favoriteProductsRepository;

    @Autowired
    public FavoriteProductsService(FavoriteProductsRepository favoriteProductsRepository) {
        this.favoriteProductsRepository = favoriteProductsRepository;
    }

    public List<FavoriteProductsDTO> getFavoriteProducts() {
        List<FavoriteProducts> favoriteProducts = favoriteProductsRepository.findAll();
        return favoriteProducts.stream()
                .map(FavoriteProductsBuilder::toFavoriteProductsDTO)
                .collect(Collectors.toList());
    }

    public Long insertFavoriteProducts(FavoriteProductsDTO favoriteProductsDTO) {
        FavoriteProducts favoriteProducts = FavoriteProductsBuilder.toFavoriteProducts(favoriteProductsDTO);
        return FavoriteProductsBuilder.toFavoriteProductsDTO(favoriteProductsRepository.save(favoriteProducts)).getFavoriteProductsId();
    }

    public void deleteFavoriteProducts(Long favoriteProductsId) {
        Optional<FavoriteProducts> favoriteProducts = favoriteProductsRepository.findById(favoriteProductsId);
        if (!favoriteProducts.isPresent()) {
            throw new ResourceNotFoundException("FavoriteProducts with id " + favoriteProductsId + " not found.");
        }
        favoriteProductsRepository.deleteById(favoriteProductsId);
    }
}
