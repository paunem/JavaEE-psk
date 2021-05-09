package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Owner;
import lt.vu.persistence.OwnerDAO;
import lt.vu.services.InsuranceCostCalculator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class InsuranceCost implements Serializable {

    @Inject
    OwnerDAO ownerDAO;

    @Inject
    InsuranceCostCalculator insuranceCostCalculator;

    private CompletableFuture<Double> costCalculationTask = null;

    @Getter
    @Setter
    private int ownerId;

    public String calculateCost() {
        Owner owner = ownerDAO.getById(this.ownerId);
        costCalculationTask = CompletableFuture.supplyAsync(() -> insuranceCostCalculator.calculateCost(owner));
        return "owner?faces-redirect=true&oId=" + this.ownerId;
    }

    public boolean isCalculatingCost() {
        return costCalculationTask != null && !costCalculationTask.isDone();
    }

    public String costCalculatorStatus() throws ExecutionException, InterruptedException {
        if (costCalculationTask == null) {
            return null;
        } else if (isCalculatingCost()) {
            return "Calculating cost...";
        }
        return "Insurance cost for all cars: " + costCalculationTask.get() + " Euro";
    }
}
