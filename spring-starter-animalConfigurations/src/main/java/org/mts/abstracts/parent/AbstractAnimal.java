package org.mts.abstracts.parent;



import com.fasterxml.jackson.annotation.JsonValue;
import org.mts.service.Animal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birth;
    protected String secretInformation;
    protected int age;

    public AbstractAnimal() {
    }

    public AbstractAnimal(String breed, String name, BigDecimal cost, String character, LocalDate birth, String secretInformation, int age) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birth = birth;
        this.secretInformation = secretInformation;
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed)
                && Objects.equals(name, that.name)
                && Objects.equals(character, that.character)
                && Objects.equals(birth, that.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, character, birth);
    }

    @JsonValue
    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birth=" + birth +
                '}';
    }
}
