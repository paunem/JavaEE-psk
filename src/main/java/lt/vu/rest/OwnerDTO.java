package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerDTO {

    private Integer id;
    private String firstName;
    private String lastName;

    public OwnerDTO(){}
    public OwnerDTO(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
