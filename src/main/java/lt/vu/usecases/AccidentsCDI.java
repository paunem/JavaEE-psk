package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Accident;
import lt.vu.entities.Car;
import lt.vu.persistence.AccidentDAO;
import lt.vu.persistence.CarDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class AccidentsCDI implements Serializable {

    @Inject
    private CarDAO carDAO;

    @Inject
    private AccidentDAO accidentDAO;

    @Getter
    private Car car;

    @Getter
    private int carId;

    @Getter
    private List<Accident> allAccidents;

    @Getter @Setter
    private int accidentToAddId;


    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.carId = Integer.parseInt(requestParameters.get("cId"));
        loadCarAccidents();
    }

    private void loadCarAccidents() {
        this.car = carDAO.getById(carId);
        this.allAccidents = accidentDAO.loadAll();
    }

    @Transactional
    public String addAccidentToCar() {
        this.accidentDAO.addAccidentToCar(carId, accidentToAddId);
        return "accidents?faces-redirect=true&cId=" + carId;
    }
}
