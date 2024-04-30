package org.mts.lab2.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.lab2.service.impl.AnimalsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class AnimalsRepositoryImplTest {

    @Autowired
    private AnimalsRepositoryImpl animalsRepository;

//    @Test
//    public void findOlderAnimalsTest(@Mock CatFactory catFactory,
//                                     @Mock DogFactory dogFactory,
//                                     @Mock WolfFactory wolfFactory,
//                                     @Mock SharkFactory sharkFactory) {
//        Mockito.doReturn(new Cat("testBarsik", LocalDate.of(2020, 2, 25))).when(catFactory).createRandomAnimal();
//        Mockito.doReturn(new Dog("testVzhik", LocalDate.of(2010, 2, 25))).when(dogFactory).createRandomAnimal();
//        Mockito.doReturn(new Wolf("testAtos", LocalDate.of(2019, 2, 25))).when(wolfFactory).createRandomAnimal();
//        Mockito.doReturn(new Shark("testMuhtar", LocalDate.of(2016, 2, 25))).when(sharkFactory).createRandomAnimal();
//
//        ConcurrentMap<String, List<AbstractAnimal>> map = new ConcurrentHashMap<>();
//        map.put(AnimalEnum.CAT.toString(), List.of(catFactory.createRandomAnimal()));
//        map.put(AnimalEnum.DOG.toString(), List.of(dogFactory.createRandomAnimal()));
//        map.put(AnimalEnum.WOLF.toString(), List.of(wolfFactory.createRandomAnimal()));
//        map.put(AnimalEnum.SHARK.toString(), List.of(sharkFactory.createRandomAnimal()));
//
//        AnimalsRepositoryImpl animalsRepositoryTest = new AnimalsRepositoryImpl();
//        animalsRepositoryTest.animals = map;
//
//        Map<Animal, Integer> resultMap = new HashMap<>();
//        resultMap.put(new Dog("testVzhik", LocalDate.of(2010, 2, 25)), 14);
//
//        System.out.println("Anim");
//        animalsRepositoryTest.findOlderAnimal(10).forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
//        System.out.println("Result");
//        resultMap.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
//        Assertions.assertEquals(animalsRepositoryTest.findOlderAnimal(10), resultMap);
//    }
//
//    @Test
//    public void testNotNullAnimals() {
//        for (Map.Entry<String, List<AbstractAnimal>> entry : animalsRepository.getAnimals().entrySet()) {
//            List<AbstractAnimal> currentTypeAnimals = entry.getValue();
//            for (Animal currentTypeAnimal : currentTypeAnimals) {
//                Assertions.assertNotNull(currentTypeAnimal);
//            }
//        }
//    }
//
//    @Test
//    public void findAverageAge() {
//        List<AbstractAnimal> animalsList = List.of(new Cat("pete0", LocalDate.of(2015, 9, 20)),
//                new Cat("pete1", LocalDate.of(2010, 9, 20)),
//                new Cat("pete2", LocalDate.of(2014, 9, 20)));
//        CopyOnWriteArrayList<AbstractAnimal> concurrentAnimalsList = new CopyOnWriteArrayList<>(animalsList);
//        System.out.println("\n------------AverageAge-----------\n");
//        try {
//            animalsRepository.findAverageAge(concurrentAnimalsList);
//        } catch (InputListIsEmptyException exception) {
//            System.out.println("Input list is empty!");
//        }
//
//    }
//
//    @Test
//    public void findOldAndExpensive() {
//        List<AbstractAnimal> animalsList = List.of(new Cat("pete0", LocalDate.of(2020, 9, 20)),
//                new Wolf("pete1", LocalDate.of(2011, 9, 19)),
//                new Wolf("pete2", LocalDate.of(2010, 9, 19)));
//        CopyOnWriteArrayList<AbstractAnimal> concurrentAnimalsList = new CopyOnWriteArrayList<>(animalsList);
//        System.out.println("\n------------OldAndExpensive-----------\n");
//        try {
//            System.out.println(animalsRepository.findOldAndExpensive(concurrentAnimalsList));
//        } catch (InputListIsEmptyException exception) {
//            System.out.println("Input list is empty!");
//        }
//
//    }
//
//    @Test
//    public void findMinCostAnimals() {
//        CopyOnWriteArrayList<AbstractAnimal> animals = new CopyOnWriteArrayList<>(new AbstractAnimal[]{(new Cat("dior", LocalDate.of(2020, 9, 20))),
//                new Cat("diorb", LocalDate.of(2020, 9, 20)),
//                new Cat("diorc", LocalDate.of(2010, 5, 10)),
//                new Cat("diord", LocalDate.of(2015, 2, 15)),
//                new Wolf("pete4", LocalDate.of(2011, 9, 19)),
//                new Wolf("pete5", LocalDate.of(2010, 9, 19))});
//        System.out.println("\n------------MinCostAnimals-----------\n");
//        try {
//            System.out.println(animalsRepository.findMinCostAnimals(animals));
//        } catch (InputListLessThreeElemsException exception) {
//            System.out.println("Input list has less than 3 elements!");
//        }
//    }
//
//    @Test
//    public void findDuplicates(@Mock CatFactory catFactory,
//                               @Mock DogFactory dogFactory,
//                               @Mock WolfFactory wolfFactory,
//                               @Mock SharkFactory sharkFactory) {
//        Mockito.doReturn(new Cat("testBarsik", LocalDate.of(2020, 2, 25))).when(catFactory).createRandomAnimal();
//        Mockito.doReturn(new Dog("testVzhik", LocalDate.of(2013, 2, 25))).when(dogFactory).createRandomAnimal();
//        Mockito.doReturn(new Wolf("testAtos", LocalDate.of(2019, 2, 25))).when(wolfFactory).createRandomAnimal();
//        Mockito.doReturn(new Shark("testMuhtar", LocalDate.of(2016, 2, 25))).when(sharkFactory).createRandomAnimal();
//
//        ConcurrentMap<String, List<AbstractAnimal>> map = new ConcurrentHashMap<>();
//        map.put(AnimalEnum.CAT.toString(), List.of(catFactory.createRandomAnimal(), catFactory.createRandomAnimal(), catFactory.createRandomAnimal()));
//        map.put(AnimalEnum.DOG.toString(), List.of(dogFactory.createRandomAnimal(), dogFactory.createRandomAnimal()));
//        map.put(AnimalEnum.WOLF.toString(), List.of(wolfFactory.createRandomAnimal()));
//        map.put(AnimalEnum.SHARK.toString(), List.of(sharkFactory.createRandomAnimal(), sharkFactory.createRandomAnimal()));
//
//        AnimalsRepositoryImpl animalsRepositoryTest = new AnimalsRepositoryImpl();
//        animalsRepositoryTest.animals = map;
//
//        Map<String, List<Animal>> resultMap = new HashMap<>();
//        resultMap.put("CAT", List.of(new Cat("testBarsik", LocalDate.of(2020, 2, 25)), new Cat("testBarsik", LocalDate.of(2020, 2, 25)), new Cat("testBarsik", LocalDate.of(2020, 2, 25))));
//        resultMap.put("DOG", List.of(new Dog("testVzhik", LocalDate.of(2013, 2, 25)), new Dog("testVzhik", LocalDate.of(2013, 2, 25))));
//        resultMap.put("SHARK", List.of(new Shark("testMuhtar", LocalDate.of(2016, 2, 25)), new Shark("testMuhtar", LocalDate.of(2016, 2, 25))));
//
//        Assertions.assertEquals(animalsRepositoryTest.findDuplicate(), resultMap);
//    }
}
