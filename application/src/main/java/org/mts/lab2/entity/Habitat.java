package org.mts.lab2.entity;

import org.springframework.stereotype.Component;

@Component
public class Habitat {
    private Long id;
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
