package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.categoryDTOs.CategoryDTO;
import ro.tuc.ds2020.services.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = categoryService.findCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertCategory(@RequestBody CategoryDTO categoryDTO) {
        Long categoryId = categoryService.insertCategory(categoryDTO);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(categoryId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(categoryId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            categoryService.updateCategory(categoryDTO);
            return new ResponseEntity<>(categoryDTO.getCategoryId(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(categoryDTO.getCategoryId(), HttpStatus.NOT_FOUND);
        }
    }
}
