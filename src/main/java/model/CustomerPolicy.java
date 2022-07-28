package model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_policy")
public class CustomerPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne(targetEntity=Customer.class)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne(targetEntity=Agency.class)
    @JoinColumn(name="agency_id")
    private Agency agency;

    @Column(name="policy_id")
    private long policy_id;

    @Column(name="date")
    private Date date;
    @Column(name="insurance_amount")
    private double insurance_amount;
    @Column(name="is_active")
    private boolean is_active;

    public String toString() {
        return String.format("%f - %b", this.insurance_amount,this.is_active);
    }
}
