import com.eminkabacaoglu.finalproject.model.Policy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eminkabacaoglu.finalproject.service.CustomerPolicyService;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerPolicyServiceTest {

    private CustomerPolicyService customerPolicyService;
    @Before
    public void setup(){
        AbstractApplicationContext ctx = null;
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        customerPolicyService = ctx.getBean(CustomerPolicyService.class);
    }

    @Test
    public void test_getPaymentByYear(){

        int actualResult=customerPolicyService.getPaymentByYear().size();
        assertThat(actualResult).isEqualTo(13);
    }

    @Test
    public void test_getAgencyPerformanceInfos(){
        String actualResult=customerPolicyService.getAgencyPerformanceInfos().get(0).getClass().getSimpleName();
        assertThat(actualResult).isEqualTo("AgencyPerformance");
    }

    @Test
    public void test_getQuantityOfPoliciesByCity(){
        String actualResult=customerPolicyService.getQuantityOfPoliciesByCity().getClass().getSimpleName();
        assertThat(actualResult).isEqualTo("LinkedHashMap");
    }

    @Test
    public void test_getPolicyTypeTotalAmount(){
        HashMap<String,Double> testMap = new HashMap<>();
        LinkedHashMap<Policy,Double> list=customerPolicyService.getPolicyTypeTotalAmount();
        for (Policy policy: list.keySet()){
            testMap.put(policy.getName(),list.get(policy));
        }
        assertThat(testMap.get("Health Insurance")).isEqualTo(21497748.12);
        assertThat(testMap.get("Life Insurance")).isEqualTo(24111230.49);
        assertThat(testMap.get("Property Insurance")).isEqualTo(21708983.71);
        assertThat(testMap.get("Accident Insurance")).isEqualTo(22351410.91);

    }

}
