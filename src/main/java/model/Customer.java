package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="birth_date")
    private Date birth_date;

    public String toString() {
        return String.format("%d-%s-%s", this.id, this.first_name,this.last_name);
    }
}
