package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.specsDTOs.SpecsDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsWithCategoriesDTO;
import ro.tuc.ds2020.entities.Category;
import ro.tuc.ds2020.entities.Specs;

import java.util.List;
import java.util.stream.Collectors;

public class SpecsBuilder {

    public static Specs toSpecs(SpecsDTO specsDTO) {
        return new Specs(specsDTO.getSpecsId(),
                specsDTO.getWeight(),
                specsDTO.getSize());
    }

    public static Specs toSpecs(SpecsWithCategoriesDTO specsWithCategoriesDTO) {
        return new Specs(specsWithCategoriesDTO.getSpecsId(),
                specsWithCategoriesDTO.getCategories().stream().map(CategoryBuilder::toCategory).collect(Collectors.toList()),
                specsWithCategoriesDTO.getWeight(),
                specsWithCategoriesDTO.getSize());
    }

    public static Specs toSpecs(SpecsDTO specsDTO, List<Category> categories) {
        return new Specs(specsDTO.getSpecsId(),
                categories,
                specsDTO.getWeight(),
                specsDTO.getSize());
    }

    public static SpecsDTO toSpecsDTO(Specs specs) {
        return new SpecsDTO(specs.getSpecsId(),
                specs.getWeight(),
                specs.getSize());
    }

    public static SpecsWithCategoriesDTO toSpecsWithCategoriesDTO(Specs specs) {
        return new SpecsWithCategoriesDTO(specs.getSpecsId(),
                specs.getCategories().stream().map(CategoryBuilder::toCategoryDTO).collect(Collectors.toList()),
                specs.getWeight(),
                specs.getSize());
    }
}
