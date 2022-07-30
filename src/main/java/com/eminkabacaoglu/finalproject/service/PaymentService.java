package com.eminkabacaoglu.finalproject.service;

import com.eminkabacaoglu.finalproject.repository.PaymentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
@Service
@Data
public class PaymentService {

    PaymentRepository paymentRepository;
    public LinkedHashMap<String,Double> getPaymentByYear(){
        return this.paymentRepository.paymentsByYear();
    }
}
