package org.mts.lab2;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.mts.lab2.service.DefaultCreationOfAnimalService;

public class Application {
    public static final CreateAnimalServiceImpl impl = new CreateAnimalServiceImpl();
    public static final DefaultCreationOfAnimalService defaultImpl = new DefaultCreationOfAnimalService();

    public static void main(String[] args) {
        impl.createAnimals();
        impl.createParticularNumberOfAnimals(5);
        defaultImpl.createAnimals();
    }
}
