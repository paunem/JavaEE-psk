package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarDTO {

    private Integer id;
    private String vin;
    private String manufacturer;
    private String model;
    private Integer ownerId;

    public CarDTO(Integer id, String vin, String manufacturer, String model, Integer ownerId) {
        this.id = id;
        this.vin = vin;
        this.manufacturer = manufacturer;
        this.model = model;
        this.ownerId = ownerId;
    }
}
