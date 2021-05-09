package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Car;
import lt.vu.persistence.CarDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Model
public class UpdateCarInfo implements Serializable {

    @Inject
    CarDAO carDAO;

    @Getter
    private Car car;

    @Getter
    private int carId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.carId = Integer.parseInt(requestParameters.get("cId"));
        this.car = carDAO.getById(carId);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String updateManufacturer() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        try {
            carDAO.update(this.car);
        } catch (OptimisticLockException e) {
            return "accidents?cId=" + this.car.getId() + "&faces-redirect=true&error=optimistic-lock-exception";
        }
        return "accidents?cId=" + this.car.getId() + "&faces-redirect=true";
    }

    @Transactional
    public String updateModel() {
        carDAO.update(this.car);
        return "accidents.xhtml?cId=" + this.car.getId() + "&faces-redirect=true";
    }
}
