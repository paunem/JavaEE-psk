package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Car;
import lt.vu.entities.Owner;
import lt.vu.persistence.CarDAO;
import lt.vu.persistence.OwnerDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class OwnerCDI {

    @Inject
    private OwnerDAO ownerDAO;

    @Inject
    private CarDAO carDAO;

    @Getter
    private Owner owner;

    @Getter
    private int ownerId;

    @Getter @Setter
    private Car carToCreate = new Car();


    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        ownerId = Integer.parseInt(requestParameters.get("oId"));
        loadOwner();
    }

    private void loadOwner() {
        this.owner = ownerDAO.getById(ownerId);
    }

    @Transactional
    public String createCar() {
        carToCreate.setOwner(this.owner);
        carDAO.persist(carToCreate);
        carToCreate = new Car();
        return "owner?faces-redirect=true&oId=" + ownerId;
    }
}
