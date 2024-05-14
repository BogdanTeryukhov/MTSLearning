package org.mts.abstracts.parent;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.mts.inheritors.Cat;
import org.mts.inheritors.Dog;
import org.mts.inheritors.Shark;
import org.mts.inheritors.Wolf;
import org.mts.service.Animal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "breed"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wolf.class, name = "Волк"),
        @JsonSubTypes.Type(value = Cat.class, name = "Кошка"),
        @JsonSubTypes.Type(value = Dog.class, name = "Собака"),
        @JsonSubTypes.Type(value = Shark.class, name = "Акула")
})
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

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCharacter() {
        return character;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getSecretInformation() {
        return secretInformation;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
