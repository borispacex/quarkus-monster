package io.readeasy.monster.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Car extends PanacheEntity {

    // public Long id;
    @Column(length = 16)
    public String model;
    @Column(length = 16)
    public String bodyType;
    @Column(length = 16)
    public String brand;
    public String year;
    public Double price;
    public Integer seats;
    public Integer doors;
    @Column(length = 128)
    public String urlImage;

}
