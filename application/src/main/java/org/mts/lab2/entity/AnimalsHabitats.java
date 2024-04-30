package org.mts.lab2.entity;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "animals_habitats", schema = "animals")
public class AnimalsHabitats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimalType;
    @Column(name = "id_area")
    private Long idArea;

    public AnimalsHabitats() {
    }

    public AnimalsHabitats(Long idAnimalType, Long idArea) {
        this.idAnimalType = idAnimalType;
        this.idArea = idArea;
    }

    public Long getIdAnimalType() {
        return idAnimalType;
    }

    public void setIdAnimalType(Long idAnimalType) {
        this.idAnimalType = idAnimalType;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    @Override
    public String toString() {
        return "AnimalsHabitats{" +
                "idAnimalType=" + idAnimalType +
                ", idArea=" + idArea +
                '}';
    }
}
