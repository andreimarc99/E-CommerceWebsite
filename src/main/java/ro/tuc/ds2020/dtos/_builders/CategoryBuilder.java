package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.categoryDTOs.CategoryDTO;
import ro.tuc.ds2020.entities.Category;

public class CategoryBuilder {
    public static Category toCategory(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getCategoryId(),
                categoryDTO.getName());
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(category.getCategoryId(),
                category.getName());
    }
}
