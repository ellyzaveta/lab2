import java.util.List;
import java.util.Random;

public class Test {
    public static void test() {
        Random rm = new Random();

        int numOfCars = rm.nextInt(50, 100);
        CarBuilder carBuilder = new CarBuilder();
        List<Car> cars = carBuilder.getArrOfRandCars(numOfCars);


        String brand = carBuilder.randBrand();
        String model = carBuilder.randModel();
        int years = rm.nextInt(1, 10);
        Integer year = carBuilder.randReleaseYear();
        double price = carBuilder.randPrice();

        List<Car> carsOfBrand = Manager.listOfCarsByBrand(cars, brand);
        List<Car> carsOfModelAndYear = Manager.listOfCarsByModelAndYear(cars, model, years);
        List<Car> carsOfYearAndPrice = Manager.listOfCarsByYearAndPrice(cars, year, price);

        System.out.println();
        System.out.println("\u001B[35m List of cars \u001B[0m");
        System.out.println(cars);
        System.out.println();
        System.out.printf("\u001B[35m List of cars of brand %s \u001B[0m%n", brand);
        System.out.println(carsOfBrand);
        System.out.println();
        System.out.printf("\u001B[35m List of cars of a model %s that have been used for more than %d years \u001B[0m%n", model, years);
        System.out.println(carsOfModelAndYear);
        System.out.println();
        System.out.printf("\u001B[35m List of cars of %d year of manufacture, the price of which is higher than %f $ \u001B[0m%n", year, price);
        System.out.println(carsOfYearAndPrice);
        System.out.println();

    }

    public static void main(String[] args) {
        test();
    }
}