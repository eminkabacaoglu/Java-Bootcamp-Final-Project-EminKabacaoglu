package model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="agency_name")
    private String agency_name;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;

    public String toString() {
        return String.format("%d-%s-(%s)", this.id, this.agency_name,this.city);
    }
}
