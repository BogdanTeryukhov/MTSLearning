package org.mts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "creature", schema = "animals")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Creature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "age")
    private short age;
    @Column(name = "secret_info")
    private String secretInfo;

    @ManyToOne(targetEntity = AnimalType.class)
    @JoinColumn(name = "creature_id")
    private AnimalType type;

    public Creature() {
    }

    public Creature(String name, int typeId, short age, AnimalType type) {
        this.name = name;
        this.typeId = typeId;
        this.age = age;
        this.type = type;
    }

    public Creature(String name, int typeId, AnimalType type) {
        this.name = name;
        this.typeId = typeId;
        this.age = (short) ThreadLocalRandom.current().nextInt(1, 100);
        this.type = type;
    }

    public Creature(Long id, String name, int typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.age = (short) ThreadLocalRandom.current().nextInt(1, 100);
    }

    public Creature(Long id, String name, int typeId, short age, String secretInfo) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.age = age;
        this.secretInfo = secretInfo;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return typeId == creature.typeId && age == creature.age && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeId, age);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", age=" + age +
                ", secretInfo='" + secretInfo + '\'' +
                ", type=" + type +
                '}';
    }
}
