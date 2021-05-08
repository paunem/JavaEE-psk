package lt.vu.persistence;

import lt.vu.entities.Owner;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.List;

@Specializes
@ApplicationScoped
public class OwnerDAOCounting extends OwnerDAO{

    private static int ownersCounter;

    @PostConstruct
    private void setCounter(){
        ownersCounter = super.loadAll().size();
    }

    @Override
    public void persist(Owner owner){
        super.persist(owner);
        ownersCounter++;
        System.out.println("We have " + ownersCounter + " clients");
    }

    @Override
    public List<Owner> loadAll() {
        System.out.println("We have " + ownersCounter + " clients");
        return super.loadAll();
    }

    @Override
    public Owner getById(int id){
        System.out.println("We have " + ownersCounter + " clients");
        return super.getById(id);
    }
}
