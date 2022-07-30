package com.eminkabacaoglu.finalproject.util;

import com.eminkabacaoglu.finalproject.service.PaymentService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eminkabacaoglu.finalproject.service.CustomerPolicyService;

public class Responder {
    Show show = new Show();
    CustomerPolicyService customerPolicyService = new CustomerPolicyService();
    AbstractApplicationContext ctx = null;


    public void find(String response) {
        if(response.equalsIgnoreCase("1")){
            try {
                ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
                CustomerPolicyService custService = ctx.getBean(CustomerPolicyService.class);
                this.show.showPolicyTypeTotalAmount(custService.getPolicyTypeTotalAmount());

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(ctx != null)
                    ctx.close();
            }
        }
        else if(response.equalsIgnoreCase("2")){
            try {
                ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
                PaymentService payService = ctx.getBean(PaymentService.class);
                this.show.showPaymentsByYear(payService.getPaymentByYear());

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(ctx != null)
                    ctx.close();
            }
        }
        else if(response.equalsIgnoreCase("3")){
            try {
                ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
                CustomerPolicyService custService = ctx.getBean(CustomerPolicyService.class);
                this.show.showQuantityOfPoliciesByCity(custService.getQuantityOfPoliciesByCity());

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(ctx != null)
                    ctx.close();
            }
        }
        else if(response.equalsIgnoreCase("4")){

            try {
                ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
                CustomerPolicyService custService = ctx.getBean(CustomerPolicyService.class);
                this.show.showAgencyPerformanceTable(custService.getAgencyPerformanceInfos());

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(ctx != null)
                    ctx.close();
            }

        }
        else if (response.equalsIgnoreCase("E")) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid Selection");
        }

    }


}
