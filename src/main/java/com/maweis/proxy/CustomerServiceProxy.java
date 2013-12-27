package com.maweis.proxy;

import com.maweis.dto.CustomerDTO;

/**
 * Created by peter on 12/25/13.
 */
public interface CustomerServiceProxy  {

    public CustomerDTO findCustomerById(long id);

}
