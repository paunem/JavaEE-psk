package lt.vu.persistence;

import lt.vu.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class CarDAOCatB extends CarDAO implements ICarDAO {

    @Override
    public void persist(Car car){
        car.setCategory("B");
        super.persist(car);
        System.out.println("Persisted with CarDAOCatB");
    }
}
