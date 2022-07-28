package service;



import lombok.Data;
import model.AgencyPerformance;
import model.Policy;
import org.springframework.stereotype.Service;
import repository.CustomerPolicyRepository;

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

    public LinkedHashMap<String,Double> getPaymentByYear(){
        return this.customerPolicyRepository.paymentsByYear();
    }

    public LinkedHashMap<String,Integer> getQuantityOfPoliciesByCity(){
        return this.customerPolicyRepository.quantityOfPoliciesByCity();
    }

    public List<AgencyPerformance> getAgencyPerformanceInfos(){
        return this.customerPolicyRepository.agencyPerformance();
    }





}
