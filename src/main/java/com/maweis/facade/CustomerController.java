package com.maweis.facade;

import com.maweis.dto.CustomerDTO;
import com.maweis.proxy.CustomerServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by peter on 12/17/13.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerServiceProxy customerServiceProxy;


    @RequestMapping(value = "/customers/{customerId}.json", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody CustomerDTO findCustomer(@PathVariable int customerId) {

        CustomerDTO customerDTO = customerServiceProxy.findCustomerById(customerId);
        System.out.println(customerDTO);
        return customerDTO;
    }


}
