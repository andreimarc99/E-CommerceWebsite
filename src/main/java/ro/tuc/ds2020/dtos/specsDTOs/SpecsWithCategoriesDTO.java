package ro.tuc.ds2020.dtos.specsDTOs;

import ro.tuc.ds2020.dtos.categoryDTOs.CategoryDTO;
import ro.tuc.ds2020.entities.Category;
import java.util.ArrayList;
import java.util.List;

public class SpecsWithCategoriesDTO {

    private Long specsId;
    private List<CategoryDTO> categories = new ArrayList<>();
    private Float weight;
    private String size;

    public SpecsWithCategoriesDTO() {}

    public SpecsWithCategoriesDTO(Long specsId, List<CategoryDTO> categories, Float weight, String size) {
        this.specsId = specsId;
        this.categories = categories;
        this.weight = weight;
        this.size = size;
    }

    public Long getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Long specsId) {
        this.specsId = specsId;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString() {
        return "ID: " + specsId + ", weight: " + weight + ", size: " + size;
    }
}
