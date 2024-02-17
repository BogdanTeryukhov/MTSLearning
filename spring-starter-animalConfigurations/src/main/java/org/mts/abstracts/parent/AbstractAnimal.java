package org.mts.abstracts.parent;



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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed)
                && Objects.equals(name, that.name)
                && Objects.equals(cost, that.cost)
                && Objects.equals(character, that.character)
                && Objects.equals(birth, that.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birth);
    }

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
