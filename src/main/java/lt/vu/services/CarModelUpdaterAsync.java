package lt.vu.services;

import lt.vu.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CarModelUpdaterAsync {

    @PersistenceContext
    @Async
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String update(Integer id, String model, long wait1, long wait2) {
        try {
            Thread.sleep(wait1);
            Car car = em.find(Car.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            Thread.sleep(wait2);
            car.setModel(model);
            em.flush();
        }
        catch (OptimisticLockException e) {
            System.out.println("OptimisticLockException in CarModelUpdaterAsync");
            return "OptimisticLockException";
        } catch (InterruptedException e) {}
        return "Updated";
    }
}
