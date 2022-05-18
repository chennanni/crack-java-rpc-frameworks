package org.example.hessian.client;

import org.example.hessian.core.GetStockPriceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class HessianClient {

    // register service
    @Bean
    public HessianProxyFactoryBean hessianInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/get_stock_price");
        invoker.setServiceInterface(GetStockPriceService.class);
        return invoker;
    }

    public static void main(String[] args) {
        // start application without web server
        SpringApplication application = new SpringApplication(HessianClient.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        // get service bean
        GetStockPriceService service = application.run(args).getBean(GetStockPriceService.class);
        // call service method
        System.out.println("=== start ===");
        System.out.println("apple: " + service.getStockPrice("apple"));
        System.out.println("taobao: " + service.getStockPrice("taobao"));
        System.out.println("=== end ===");
    }

}