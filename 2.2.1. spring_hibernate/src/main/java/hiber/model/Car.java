package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Component
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String model;
    @Column
    private String series;

    @OneToOne(mappedBy = "userCar")
    private User ownerCar;

    public Car() {}

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    public User getOwnerCar() {
        return ownerCar;
    }

    public void setOwnerCar(User ownerCar) {
        this.ownerCar = ownerCar;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series='" + series + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(model, car.model) && Objects.equals(series, car.series) && Objects.equals(ownerCar, car.ownerCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series, ownerCar);
    }
}
