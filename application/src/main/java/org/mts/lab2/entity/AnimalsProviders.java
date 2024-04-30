package org.mts.lab2.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "animals_providers", schema = "animals")
public class AnimalsProviders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimalType;
    @Column(name = "id_provider")
    private Long idProvider;

    public AnimalsProviders() {
    }

    public AnimalsProviders(Long idAnimalType, Long idProvider) {
        this.idAnimalType = idAnimalType;
        this.idProvider = idProvider;
    }

    public Long getIdAnimalType() {
        return idAnimalType;
    }

    public void setIdAnimalType(Long idAnimalType) {
        this.idAnimalType = idAnimalType;
    }

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    @Override
    public String toString() {
        return "AnimalsProviders{" +
                "idAnimalType=" + idAnimalType +
                ", idProvider=" + idProvider +
                '}';
    }
}

