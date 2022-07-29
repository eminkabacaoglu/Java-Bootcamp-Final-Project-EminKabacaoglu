package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne(targetEntity=CustomerPolicy.class)
    @JoinColumn(name="customer_policy_id")
    private CustomerPolicy customer;

    @Column(name="date")
    private Date date;
    @Column(name="payment_amount")
    private double payment_amount;

    public String toString() {
        return String.format("%d-%s - %f", this.id,this.payment_amount);
    }
}
