package org.mts.dto;

import jakarta.persistence.*;
import org.mts.entity.AnimalType;
import org.springframework.stereotype.Component;

@Component
public class CreatureDTO {
    private Long id;
    private String name;
    private int typeId;
    private short age;
    private String secretInfo;
    private AnimalType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getSecretInfo() {
        return secretInfo;
    }

    public void setSecretInfo(String secretInfo) {
        this.secretInfo = secretInfo;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }
}
