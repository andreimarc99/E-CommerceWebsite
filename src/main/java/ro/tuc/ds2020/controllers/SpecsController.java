package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsWithCategoriesDTO;
import ro.tuc.ds2020.services.SpecsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/specs")
public class SpecsController {
    private final SpecsService specsService;

    @Autowired
    public SpecsController(SpecsService specsService) {
        this.specsService = specsService;
    }

    @GetMapping()
    public ResponseEntity<List<SpecsWithCategoriesDTO>> getSpecs() {
        List<SpecsWithCategoriesDTO> specsWithCategoriesDTOS = specsService.getSpecs();
        return new ResponseEntity<>(specsWithCategoriesDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertSpecs(@RequestBody SpecsWithCategoriesDTO specsWithCategoriesDTO) {
        try {
            specsService.insertSpecs(specsWithCategoriesDTO);
            return new ResponseEntity<>(specsWithCategoriesDTO.getSpecsId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{specsId}")
    public ResponseEntity<Long> deleteSpecs(@PathVariable Long specsId) {
        try {
            specsService.deleteSpecs(specsId);
            return new ResponseEntity<>(specsId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateSpecs(@RequestBody SpecsDTO specsDTO) {
        try {
            specsService.updateSpecs(specsDTO);
            return new ResponseEntity<>(specsDTO.getSpecsId(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
