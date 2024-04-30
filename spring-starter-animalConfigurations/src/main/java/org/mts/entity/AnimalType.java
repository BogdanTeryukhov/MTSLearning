package org.mts.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "animal_type", schema = "animals")
public class AnimalType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "is_wild")
    private boolean isWild;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "creature_id")
    private List<Creature> creatures;

    public AnimalType() {
    }

    public AnimalType(Long id, boolean isWild, String type) {
        this.id = id;
        this.isWild = isWild;
        this.type = type;
    }

    public AnimalType(Long id, String type, boolean isWild, List<Creature> creatures) {
        this.id = id;
        this.type = type;
        this.isWild = isWild;
        this.creatures = creatures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", isWild=" + isWild +
                ", creatures=" + creatures +
                '}';
    }
}
