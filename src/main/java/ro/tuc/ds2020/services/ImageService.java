package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Image;
import ro.tuc.ds2020.repositories.ImageRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getImages() {
       return imageRepository.findAll();
    }

    public Image getImageById(Long imageId) {
        Optional<Image> img = imageRepository.findById(imageId);
        if (!img.isPresent()) {
            throw new ResourceNotFoundException("Image with id " + imageId + " not found.");
        }
        return img.get();
    }

    public String insertImage(Image image) {
        return imageRepository.save(image).getName();
    }
}
