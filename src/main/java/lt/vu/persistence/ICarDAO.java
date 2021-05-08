package lt.vu.persistence;

import lt.vu.entities.Car;

import java.util.List;

public interface ICarDAO {
    void persist(Car car);

    Car update(Car car);

    List<Car> loadAll();

    Car getById(int id);
}
