package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Owner;
import lt.vu.persistence.OwnerDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class IndexCDI {

    @Inject
    private OwnerDAO ownerDAO;

    @Getter
    private List<Owner> allOwners;

    @Getter @Setter
    private Owner ownerToCreate = new Owner();

    @PostConstruct
    public void init(){
        loadAllOwners();
    }

    private void loadAllOwners(){
        this.allOwners = ownerDAO.loadAll();
    }

    @Transactional
    public String createOwner() {
        ownerDAO.persist(ownerToCreate);
        ownerToCreate = new Owner();
        return "index?faces-redirect=true";
    }
}
