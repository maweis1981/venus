package com.maweis.proxy;

import com.maweis.core.JsonRpcProxyUtil;
import com.maweis.dto.CustomerDTO;

import com.maweis.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by peter on 12/25/13.
 */
@Service
public class CustomerServiceProxyImpl implements CustomerServiceProxy {
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceProxyImpl.class);

    private CustomerService api = JsonRpcProxyUtil.getService(CustomerService.class);

    @Override
    public CustomerDTO findCustomerById(long id) {
        return api.findCustomerById(id);
    }
}
