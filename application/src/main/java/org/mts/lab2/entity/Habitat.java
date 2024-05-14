package org.mts.lab2.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


import java.io.Serializable;

@Entity
@Table(name = "habitat", schema = "animals")
public class Habitat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "area")
    private String area;

    public Habitat() {
    }

    public Habitat(Long id, String area) {
        this.id = id;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", area='" + area + '\'' +
                '}';
    }
}
