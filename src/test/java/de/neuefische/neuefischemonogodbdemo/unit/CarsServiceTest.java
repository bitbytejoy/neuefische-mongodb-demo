package de.neuefische.neuefischemonogodbdemo.unit;

import de.neuefische.neuefischemonogodbdemo.Car;
import de.neuefische.neuefischemonogodbdemo.CarsRepository;
import de.neuefische.neuefischemonogodbdemo.CarsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarsServiceTest {
    @Test
    void create_whenCar_thenCreateCar () {
        // given
        Car car = new Car(null, "BMW", 1985);

        CarsRepository carsRepository = Mockito.mock(CarsRepository.class);
        Mockito.when(carsRepository.save(car))
                .thenReturn(new Car("1", "BMW", 1985));
        CarsService carsService = new CarsService(carsRepository);

        // when
        Car actual = carsService.create(car);

        // then

        Car expected = new Car("1", "BMW", 1985);
        Assertions.assertEquals(expected, actual);

        Mockito.verify(carsRepository).save(car);
    }
}