package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.CategoryBuilder;
import ro.tuc.ds2020.dtos.categoryDTOs.CategoryDTO;
import ro.tuc.ds2020.entities.Category;
import ro.tuc.ds2020.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(CategoryBuilder::toCategoryDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findCategoryByName(String name) {
        Optional<Category> category = categoryRepository.getCategoryByName(name);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("Category with name " + name + " not found.");
        }
        return CategoryBuilder.toCategoryDTO(category.get());
    }

    public Long insertCategory(CategoryDTO categoryDTO) {
        Category category = CategoryBuilder.toCategory(categoryDTO);
        category = categoryRepository.save(category);
        LOGGER.debug("Category with id {} was inserted in db", category.getCategoryId());
        return category.getCategoryId();
    }

    public void deleteCategory(Long categoryId) throws ResourceNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("Category with id " + categoryId + " not found.");
        }
        categoryRepository.deleteById(categoryId);
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) throws ResourceNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryDTO.getCategoryId());
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("Category with id " + categoryDTO.getCategoryId() + " not found.");
        }
        Category updatedCategory = CategoryBuilder.toCategory(categoryDTO);
        categoryRepository.save(updatedCategory);
        return CategoryBuilder.toCategoryDTO(updatedCategory);
    }
}
