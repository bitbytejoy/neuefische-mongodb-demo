package de.neuefische.neuefischemonogodbdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarsService {
    private final CarsRepository carsRepository;

    public Car create (Car car) {
        return carsRepository.save(car);
    }

    public List<Car> getAll () {
        return carsRepository.findAll();
    }

    public Car update (Car car) {
        return carsRepository.save(car);
    }

    public void delete (String id) {
        carsRepository.deleteById(id);
    }
}
