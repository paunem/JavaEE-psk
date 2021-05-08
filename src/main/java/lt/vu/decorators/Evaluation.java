package lt.vu.decorators;

import lt.vu.entities.Car;
import lt.vu.entities.Owner;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@RequestScoped
public class Evaluation implements IEvaluation, Serializable {

    public int evaluateOwner(Owner owner) {
        int accidents = 0;
        for(Car car : owner.getCars()){
            accidents += car.getAccidents().size();
        }
        System.out.println(owner.getFirstName() + " " + owner.getLastName()
        + " got into " + accidents + " accidents");
        return accidents;
    }
}
