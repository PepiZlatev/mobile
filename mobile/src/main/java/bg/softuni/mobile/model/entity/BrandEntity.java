package bg.softuni.mobile.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(name = "brand_name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<ModelEntity> models = new ArrayList<>();

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }
}
