package de.neuefische.neuefischemonogodbdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarsController {
    private final CarsService carsService;

    @PostMapping
    public Car create (@RequestBody Car car) {
        return carsService.create(car);
    }

    @GetMapping
    public List<Car> getAll () {
        return carsService.getAll();
    }

    @PutMapping("/{id}")
    public Car update (@PathVariable String id, @RequestBody Car car) {
        car.setId(id);
        return carsService.update(car);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id) {
        carsService.delete(id);
    }
}
