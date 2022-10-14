import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/* використовуємо фільтри стрімів, щоб фільтрувати елементи потоку (списку), які відповідають нашим вимогам.
* методи класу - статичні, не треба створювати додатковий об'єкт щоб їх використати.
* список передаємо в методи як парамерт. так забезпечується універсальність
* (можемо застосовувати на багатьох різних списках машин) */

public class Manager {
    public static List<Car> listOfCarsByBrand(List<Car> cars, String brand) {
        return cars.stream()
                .filter(car -> car.brand().equals(brand))
                .collect(Collectors.toList());
    }

    public static List<Car> listOfCarsByModelAndYear(List<Car> cars, String model, int year) {
        return cars.stream()
                .filter(car -> car.model().equals(model) && LocalDate.now().getYear() - car.releaseYear() > year)
                .collect(Collectors.toList());
    }

    public static List<Car> listOfCarsByYearAndPrice(List<Car> cars, Integer year, double price) {
        return cars.stream()
                .filter(car -> car.releaseYear().equals(year) && car.price() > price)
                .collect(Collectors.toList());
    }

}
