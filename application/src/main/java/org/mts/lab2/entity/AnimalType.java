package org.mts.lab2.entity;


import org.springframework.stereotype.Component;

@Component
public class AnimalType {
    private Long id;
    private String type;
    private boolean isWild;

    public AnimalType() {
    }

    public AnimalType(Long id, String type, boolean isWild) {
        this.id = id;
        this.type = type;
        this.isWild = isWild;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", isWild=" + isWild +
                '}';
    }
}
