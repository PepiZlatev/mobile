package bg.softuni.mobile.model.entity;

import bg.softuni.mobile.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(name = "model_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "image_url", nullable = false, length = 512)
    private String imageURL;

    @Column(name = "start_prod_year")
    private int startYear;

    @Column(name = "end_prod_year")
    private Long endYear;

    @ManyToOne(targetEntity = BrandEntity.class)
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ModelEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Long getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Long endYear) {
        this.endYear = endYear;
        return this;
    }


    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
