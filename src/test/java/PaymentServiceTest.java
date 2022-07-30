import com.eminkabacaoglu.finalproject.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentServiceTest {

    private PaymentService paymentService;
    @Before
    public void setup(){
        AbstractApplicationContext ctx = null;
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        paymentService = ctx.getBean(PaymentService.class);
    }

    @Test
    public void test_getPaymentByYear(){

        int actualResult=paymentService.getPaymentByYear().size();
        assertThat(actualResult).isEqualTo(13);
    }
}
