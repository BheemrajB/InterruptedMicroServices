package com.eurekaServer.department_service.config;

import com.eurekaServer.department_service.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.service.invoker.adapter.WebClientAdapter;
import org.springframework.web.service.invoker.HttpClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public HttpClientAdapter employeeWebClient(){
        return (HttpClientAdapter) WebClient
                .builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient(){

        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(employeeWebClient())
                .build();
        return proxyFactory.createClient(EmployeeClient.class);
    }
}