package org.mts.lab2.entity;

import org.springframework.stereotype.Component;

@Component
public class Creature {
    private Long id;
    private String name;
    private int typeId;
    private short age;

    public Creature() {
    }

    public Creature(Long id, String name, int typeId, short age) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", age=" + age +
                '}';
    }
}
