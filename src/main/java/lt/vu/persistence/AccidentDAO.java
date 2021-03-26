package lt.vu.persistence;

import lt.vu.entities.Accident;
import lt.vu.entities.Car;
import lt.vu.entities.Owner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AccidentDAO {

    @Inject
    private EntityManager em;

    public void persist(Accident accident){
        this.em.persist(accident);
    }

    public Accident findOne(Integer id){
        return em.find(Accident.class, id);
    }

    public Accident update(Accident accident){
        return em.merge(accident);
    }

    public List<Accident> loadAll() {
        return em.createNamedQuery("Accident.findAll", Accident.class).getResultList();
    }

    public void addAccidentToCar(int carId, int accidentId) {
        Car car = em.find(Car.class, carId);
        Accident accident = this.findOne(accidentId);
        car.getAccidents().add(accident);
        em.merge(car);
    }

}
