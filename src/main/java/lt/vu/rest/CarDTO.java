package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Owner;

@Getter @Setter
public class CarDTO {

    private Integer id;
    private String vin;
    private String manufacturer;
    private String model;
    private Owner owner;

    public CarDTO(Integer id, String vin, String manufacturer, String model, Owner owner) {
        this.id = id;
        this.vin = vin;
        this.manufacturer = manufacturer;
        this.model = model;
        this.owner = owner;
    }
}
