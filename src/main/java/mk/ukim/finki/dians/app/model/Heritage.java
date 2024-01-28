package mk.ukim.finki.dians.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
@AllArgsConstructor
@Table(name="heritage2")
public class Heritage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String name;
    private String city;
    private String category;
    private Double lat;
    private Double lon;

    public Heritage(){}

    public Heritage( String name, String city, String category, Double lat, Double lon) {
        //this.ID = id;
        this.name = name;
        this.city = city;
        this.category = category;
        this.lat = lat;
        this.lon = lon;
    }


}
