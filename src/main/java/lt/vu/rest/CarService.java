package lt.vu.rest;

import lt.vu.entities.Car;
import lt.vu.persistence.CarDAO;
import lt.vu.persistence.OwnerDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class CarService {
    @Inject
    CarDAO carDAO;
    @Inject
    OwnerDAO ownerDAO;

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
        car.setOwner(ownerDAO.getById(carDTO.getOwnerId()));
        carDAO.update(car);
    }

    public void saveFromDTO(CarDTO carDTO) {
        Car car = new Car();
        car.setVin(carDTO.getVin());
        car.setManufacturer(carDTO.getManufacturer());
        car.setModel(carDTO.getModel());
        car.setOwner(ownerDAO.getById(carDTO.getOwnerId()));
        carDAO.persist(car);
    }
}
