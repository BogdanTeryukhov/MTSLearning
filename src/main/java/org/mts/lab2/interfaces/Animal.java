package org.mts.lab2.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {
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
}
