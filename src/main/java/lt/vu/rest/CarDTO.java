package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarDTO {

    private Integer id;
    private String vin;
    private String manufacturer;
    private String model;
    private String category;
    private OwnerDTO owner;

    public CarDTO(){}
    public CarDTO(Integer id, String vin, String manufacturer, String model, String category, OwnerDTO owner) {
        this.id = id;
        this.vin = vin;
        this.manufacturer = manufacturer;
        this.model = model;
        this.category = category;
        this.owner = owner;
    }
}
