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

    @ManyToMany ()
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
}
