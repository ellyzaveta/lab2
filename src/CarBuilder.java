import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class CarBuilder {
    private final Random random;
    private final Map<String, List<String>> brandAndModels;
    List<String> listOfColors;
    List<Integer> listOfYears;
    private String brand;
    private int id;
    public CarBuilder() {

        random = new Random();

        listOfColors = Stream.of("red", "black", "white", "grey", "blue", "purple", "orange")
                .collect(Collectors.toList());

        listOfYears = IntStream.generate(() -> random.nextInt(2000, 2022))
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        brandAndModels = Stream.of(
                        new AbstractMap.SimpleEntry<>("audi", Arrays.asList("TT", "Q5", "Q6", "GT")),
                        new AbstractMap.SimpleEntry<>("porsche", Arrays.asList("cayenne", "taycan", "panamera")),
                        new AbstractMap.SimpleEntry<>("bmw", Arrays.asList("x3", "x5", "x6")),
                        new AbstractMap.SimpleEntry<>("mercedes", Arrays.asList("AMG SL", "AMG GT", "G-Class")))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String randBrand() {
        List<String> brands = brandAndModels.keySet().stream().toList();
        brand = brands.get(random.nextInt(brands.size()));
        return brand;
    }

    public String randModel() {
        return brandAndModels.get(brand).get(random.nextInt(brandAndModels.get(brand).size()));
    }

    public Integer randReleaseYear() {
        return listOfYears.get(random.nextInt(listOfYears.size()));
    }

    private String randColor() {
        return listOfColors.get(random.nextInt(listOfColors.size()));
    }

    public double randPrice() {
        return random.nextDouble(10000, 500000);
    }

    private String randRegistrationNumber() {
        return (char) ('a' + random.nextInt(26)) + String.valueOf((char) ('a' + random.nextInt(26))) +
                random.nextInt(1000, 10000) +
                (char) ('a' + random.nextInt(26)) + (char) ('a' + random.nextInt(26));
    }

    public Car getRandSingleCar() {
        return new Car(++id, randBrand(), randModel(), randReleaseYear(), randColor(), randPrice(), randRegistrationNumber());
    }
    
    public List<Car> getArrOfRandCars(int numOfCars) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numOfCars; i++) {
            cars.add(getRandSingleCar());
        }

        return cars;
    }
}
