package lt.vu.persistence;

import lt.vu.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CarDAO implements ICarDAO{

    @Inject
    private EntityManager em;

    public void persist(Car car){
        this.em.persist(car);
    }

    public Car update(Car car){
        return em.merge(car);
    }

    public List<Car> loadAll() {
        return em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }

    public Car getById(int id){
        return em.find(Car.class, id);
    }
}
