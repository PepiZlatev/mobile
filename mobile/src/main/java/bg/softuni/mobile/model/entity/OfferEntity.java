package bg.softuni.mobile.model.entity;

import bg.softuni.mobile.model.entity.enums.Engine;
import bg.softuni.mobile.model.entity.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Engine engine;

    @Column(nullable = false)
    private String imageURL;

    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Transmission transmission;

    private int year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferEntity setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public OfferEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }
}
