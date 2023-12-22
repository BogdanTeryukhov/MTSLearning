package org.mts.lab2;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.mts.lab2.service.DefaultCreationOfAnimalService;
import org.mts.lab2.service.SearchServiceImpl;

import java.util.Arrays;

public class Application {
    public static final CreateAnimalServiceImpl createImpl = new CreateAnimalServiceImpl();
    public static final DefaultCreationOfAnimalService defaultImpl = new DefaultCreationOfAnimalService();
    public static final SearchServiceImpl searchImpl = new SearchServiceImpl();

    public static void main(String[] args){
        Animal[] animals1 = createImpl.createAnimals();
        Animal[] animals2 = createImpl.createParticularNumberOfAnimals(10);
        Animal[] animals3 = defaultImpl.createAnimals();

        System.out.println(Arrays.toString(searchImpl.findLeapYearNames(animals1)));
        System.out.println(Arrays.toString(searchImpl.findOlderAnimal(animals2, 10)));
        searchImpl.findDuplicate(animals3);
    }
}
