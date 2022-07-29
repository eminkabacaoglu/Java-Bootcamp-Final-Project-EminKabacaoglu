package com.eminkabacaoglu.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgencyPerformance {
    private Agency agency;
    private int quantityOfPolicies;
    private float policyAmount;
    private float policyPaymentAmount;
    private float ratioOfPaymentsByAmount;

    public String toString() {
        return String.format("%d-%s-(%s)", this.agency.getAgency_name());
    }
}
