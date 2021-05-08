package lt.vu.decorators;

import lt.vu.entities.Car;
import lt.vu.entities.Owner;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class EvaluationRiskDecorator implements IEvaluation {

    @Inject
    @Delegate
    @Any
    IEvaluation evaluation;

    public int evaluateOwner(Owner owner) {
        int accidents = this.evaluation.evaluateOwner(owner);
        if(accidents >= 2){
            System.out.println("***" + owner.getFirstName() + " " + owner.getLastName()
                    + " is in a risk group" + "***");
        }
        return accidents;
    }
}
