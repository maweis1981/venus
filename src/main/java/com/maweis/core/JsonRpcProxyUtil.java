package com.maweis.core;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.maweis.service.CustomerService;

/**
 * Created by peter on 12/25/13.
 */
public class JsonRpcProxyUtil {


    public static <T> T getService(Class<T> clazz) {
        try {
            return RpcServiceFactory.getServiceViaInvocation(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
