package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.SpecsBuilder;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsDTO;
import ro.tuc.ds2020.dtos.specsDTOs.SpecsWithCategoriesDTO;
import ro.tuc.ds2020.entities.Specs;
import ro.tuc.ds2020.repositories.CategoryRepository;
import ro.tuc.ds2020.repositories.SpecsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpecsService {
    private final SpecsRepository specsRepository;

    @Autowired
    public SpecsService(SpecsRepository specsRepository) {
        this.specsRepository = specsRepository;
    }

    public List<SpecsWithCategoriesDTO> getSpecs() {
        List<Specs> specs = specsRepository.findAll();
        return specs.stream()
                .map(SpecsBuilder::toSpecsWithCategoriesDTO)
                .collect(Collectors.toList());
    }

    public Long insertSpecs(SpecsWithCategoriesDTO specsWithCategoriesDTO) {
        Specs specs = SpecsBuilder.toSpecs(specsWithCategoriesDTO);
        return SpecsBuilder.toSpecsWithCategoriesDTO(specsRepository.save(specs)).getSpecsId();
    }

    public SpecsWithCategoriesDTO updateSpecs(SpecsDTO specsDTO) {
        Optional<Specs> specs = specsRepository.findById(specsDTO.getSpecsId());
        if (!specs.isPresent()) {
            throw new ResourceNotFoundException("Specs with id " + specsDTO.getSpecsId() + " not found.");
        }
        Specs updatedSpecs = SpecsBuilder.toSpecs(specsDTO, specs.get().getCategories());

        updatedSpecs = specsRepository.save(updatedSpecs);
        SpecsWithCategoriesDTO updatedSpecsDTO = SpecsBuilder.toSpecsWithCategoriesDTO(updatedSpecs);
        return updatedSpecsDTO;
    }

    public void deleteSpecs(Long specsId) {
        Optional<Specs> specs = specsRepository.findById(specsId);
        if (!specs.isPresent()) {
            throw new ResourceNotFoundException("Specs with id " + specsId + " not found.");
        }
        specsRepository.deleteById(specsId);
    }
}
