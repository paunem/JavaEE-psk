package lt.vu.rest;

import lt.vu.entities.Car;
import lt.vu.persistence.CarDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class CarService {
    @Inject
    CarDAO carDAO;

    public Car get(int id) throws NotFoundException {
        Car car = carDAO.getById(id);
        if (car == null) {
            throw new NotFoundException("ID: " + id + " not found");
        }
        return car;
    }

    public void updateFromDTO(CarDTO carDTO) {
        Car car = carDAO.getById(carDTO.getId());
        if (car == null) {
            throw new NotFoundException("ID: " + carDTO.getId() + " not found");
        }
        car.setVin(carDTO.getVin());
        car.setManufacturer(carDTO.getManufacturer());
        car.setModel(carDTO.getModel());
        carDAO.update(car);
    }

    public void saveFromDTO(CarDTO carDTO) {
        Car car = new Car(carDTO.getId(), carDTO.getVin(), carDTO.getManufacturer(),
                carDTO.getModel(), carDTO.getOwner());
        carDAO.persist(car);
    }
}
