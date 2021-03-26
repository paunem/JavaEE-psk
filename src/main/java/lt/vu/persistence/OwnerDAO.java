package lt.vu.persistence;

import lt.vu.entities.Car;
import lt.vu.entities.Owner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class OwnerDAO {

    @Inject
    private EntityManager em;

    public void persist(Owner owner){
        this.em.persist(owner);
    }

    public Owner getById(int id){
        return em.find(Owner.class, id);
    }

    public List<Owner> loadAll() {
        return em.createNamedQuery("Owner.findAll", Owner.class).getResultList();
    }
}
