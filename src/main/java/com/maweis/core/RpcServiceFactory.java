package com.maweis.core;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.maweis.dto.CustomerDTO;
import com.maweis.service.CustomerService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by peter on 12/25/13.
 */
public class RpcServiceFactory {



    public static<T> T getService(Class<T> c){
        try {
            return new RpcServiceFactory().getServiceInstance(c);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T getServiceInstance(Class<T> c) throws MalformedURLException {

        String serviceName = c.getClass().getName();

        String url = "http://localhost:8080/core-data-jpa/" + serviceName + ".json";

        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url));

        CustomerService customerService = ProxyUtil.createClientProxy(
                getClass().getClassLoader(),
                CustomerService.class,
                client);

        return (T) customerService;
    }


    public static <T> T getServiceViaInvocation(Class<T> c) {
        String clazzName = c.getClass().getName();

//        String url = "http://localhost:8080/core-data-jpa/" + clazzName + ".json";
//        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(url));

        InvocationHandler handler = new RpcServiceInvocationHandler();

        T cu = (T) Proxy.newProxyInstance(
                c.getClassLoader(),
                new Class[]{c},
                handler );

        System.out.println("running getService");

        return (T) cu;
    }
}
