package org.mts.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal extends Serializable {

    /**
     * получение породы животного
     */
    String getBreed();
    /**
     * получение имени животного
     */
    String getName();
    /**
     * получение стоимости животного
     */
    BigDecimal getCost();
    /**
     * получение характеристики животного
     */
    String getCharacter();

    /**
     * получение даты рождения животного
     */
    LocalDate getDateOfBirth();

    /**
     * получение секретной информации
     */
    String getSecretInformation();

    int getAge();

    /**
     * получение породы животного
     */
    void setBreed(String breed);
    /**
     * получение имени животного
     */
    void setName(String name);
    /**
     * получение стоимости животного
     */
    void setCost(BigDecimal cost);
    /**
     * получение характеристики животного
     */
    void setCharacter(String character);

    /**
     * получение даты рождения животного
     */
    void setBirth(LocalDate dateOfBirth);

    /**
     * получение секретной информации
     */
    void setSecretInformation(String secretInformation);

    void setAge(int age);
}
