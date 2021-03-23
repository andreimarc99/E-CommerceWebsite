package ro.tuc.ds2020.dtos.specsDTOs;

public class SpecsDTO {
    private Long specsId;
    private Float weight;
    private String size;

    public SpecsDTO() {}

    public SpecsDTO(Long specsId, Float weight, String size) {
        this.specsId = specsId;
        this.weight = weight;
        this.size = size;
    }

    public Long getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Long specsId) {
        this.specsId = specsId;
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
}
