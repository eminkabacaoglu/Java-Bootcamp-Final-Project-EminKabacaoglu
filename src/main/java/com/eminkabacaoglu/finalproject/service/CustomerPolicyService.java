package com.eminkabacaoglu.finalproject.service;



import lombok.Data;
import com.eminkabacaoglu.finalproject.model.AgencyPerformance;
import com.eminkabacaoglu.finalproject.model.Policy;
import org.springframework.stereotype.Service;
import com.eminkabacaoglu.finalproject.repository.CustomerPolicyRepository;

import java.util.LinkedHashMap;
import java.util.List;
@Service
@Data
public class CustomerPolicyService {
    CustomerPolicyRepository customerPolicyRepository;
//    public CustomerPolicyService(){
//        this.customerPolicyRepository = new CustomerPolicyRepository();
//    }


    public LinkedHashMap<Policy,Double> getPolicyTypeTotalAmount(){
        return this.customerPolicyRepository.policyAmountByPolicyType();
    }



    public LinkedHashMap<String,Integer> getQuantityOfPoliciesByCity(){
        return this.customerPolicyRepository.quantityOfPoliciesByCity();
    }

    public List<AgencyPerformance> getAgencyPerformanceInfos(){
        return this.customerPolicyRepository.agencyPerformance();
    }





}
