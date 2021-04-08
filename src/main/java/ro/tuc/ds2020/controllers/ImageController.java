package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.entities.Image;
import ro.tuc.ds2020.services.ImageService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping()
    public ResponseEntity<List<Image>> findAll() {
        List<Image> images = imageService.getImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping(value = "/{imageId}")
    public ResponseEntity<Image> findById(@PathVariable Long imageId) {
        Image image = imageService.getImageById(imageId);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
