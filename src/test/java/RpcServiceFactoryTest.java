import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.maweis.core.RpcServiceFactory;
import com.maweis.dto.CustomerDTO;
import com.maweis.service.CustomerService;
import org.junit.Test;
import org.unitils.core.Unitils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by peter on 12/25/13.
 */
public class RpcServiceFactoryTest extends Unitils {

    @Test
    public void testServiceInstance(){
        System.out.println(RpcServiceFactory.getServiceViaInvocation(CustomerService.class).findCustomerById(2L));
    }


//    @Test
    public void testLoadService(){

        try {
            String serviceName = "CustomerService";
            String url = "http://localhost:8000/mars/" + serviceName + ".json";
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url));

            CustomerService customerService = ProxyUtil.createClientProxy(
                    getClass().getClassLoader(),
                    CustomerService.class,
                    client);


            System.out.println(customerService.sayHello("Maven"));

            System.out.println(customerService.findCustomerByName("ma"));
//            CustomerDTO dto = customerService.findCustomerById(2L);
//            System.out.println(dto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
