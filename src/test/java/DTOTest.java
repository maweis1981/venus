import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.maweis.dto.CustomerDTO;

import java.net.URL;
import java.util.List;

/**
 * Created by peter on 12/25/13.
 */
public class DTOTest {

    public static void main(String[] args) {

        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL("http://localhost:8080/core-data-jpa/CustomerService.json"));


            String result = client.invoke("sayHello", new Object[] { "bob" }, String.class);
            System.out.println(result);

            System.out.println("------------------");

            CustomerDTO customer = client.invoke("findCustomerById", new Object[] {2L}, CustomerDTO.class);
            System.out.println(customer);

            System.out.println("------------------");
            List<CustomerDTO> customers = client.invoke("findCustomerByName", new Object[] {"maven"}, List.class);
            System.out.println(customers);
            for (CustomerDTO cus : customers) {
                System.out.println(cus);
            }



        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
