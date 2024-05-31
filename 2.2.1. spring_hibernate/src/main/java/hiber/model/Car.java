package hiber.model;

import javax.persistence.*;

@Entity
@Table
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
}
