package de.neuefische.neuefischemonogodbdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Car, String> {
}
