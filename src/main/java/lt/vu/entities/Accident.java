package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Time;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
@NamedQueries({
        @NamedQuery(name = "Accident.findAll", query = "select a from Accident as a")
})
@Table(name = "ACCIDENT", schema = "PUBLIC", catalog = "INSURANCE")
public class Accident implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "DATE")
    private Date date;

    @Basic
    @Column(name = "TIME")
    private Time time;

    @Basic
    @Column(name = "CITY")
    private String city;

    @ManyToMany(mappedBy = "accidents")
    private Set<Car> cars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident that = (Accident) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time);
    }
}
