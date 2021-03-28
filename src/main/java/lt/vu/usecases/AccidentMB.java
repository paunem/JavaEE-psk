package lt.vu.usecases;

import lombok.Getter;
import lt.vu.mybatis.model.Accident;
import lt.vu.mybatis.dao.AccidentMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class AccidentMB implements Serializable {

    @Inject
    private AccidentMapper accidentMapper;

    @Getter
    private Accident accident;

    @Getter
    private int accidentId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.accidentId = Integer.parseInt(requestParameters.get("aId"));
        loadAccidentCars();
    }

    private void loadAccidentCars() {
        this.accident = accidentMapper.selectByPrimaryKey(this.accidentId);
    }
}
