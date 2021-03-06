package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="specs")
public class Specs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specsId", nullable = false)
    private Long specsId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "specs_categories",
            joinColumns = @JoinColumn(name = "specsId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Category> categories = new ArrayList<>();

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "size", nullable = false)
    private String size;

    public Specs() {}

    public Specs(Long specsId, Float weight, String size) {
        this.specsId = specsId;
        this.weight = weight;
        this.size = size;
    }

    public Specs(Long specsId, List<Category> categories, Float weight, String size) {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
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
        String str = "ID: " + specsId + ", weight: " + weight + ", size: " + size;
        String cat = "";
        for (Category category : categories) {
            cat += " " + category.toString();
        }
        return str + ", categories: " + cat;
    }
}
