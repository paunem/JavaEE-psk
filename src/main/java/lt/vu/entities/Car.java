package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
@NamedQueries({
        @NamedQuery(name = "Car.findAll", query = "select c from Car as c")
})
@Table(name = "CAR", schema = "PUBLIC", catalog = "INSURANCE")
public class Car implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "VIN")
    private String vin;

    @Basic
    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Basic
    @Column(name = "MODEL")
    private String model;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @ManyToMany
    @JoinTable(
            name = "CAR_ACCIDENT",
            joinColumns = @JoinColumn(name = "CAR_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACCIDENT_ID"))
    private Set<Accident> accidents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(vin, car.vin) && Objects.equals(manufacturer, car.manufacturer) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, manufacturer, model);
    }
}
