package org.mts.lab2.interfaces;

import java.math.BigDecimal;

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
}
