package lt.vu.services;

import lt.vu.entities.Owner;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class InsuranceCostCalculator {

    public double calculateCost(Owner owner) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        double discount = new Random().nextInt(11);
        System.out.println("Disc " + discount);
        return owner.getCars().size() * 100 * (100 - discount) / 100;
    }
}
