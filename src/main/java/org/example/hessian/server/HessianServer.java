package org.example.hessian.server;

import org.example.hessian.core.GetStockPriceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class HessianServer {

    // expose the service
    @Bean(name = "/get_stock_price")
    RemoteExporter getStockPriceServiceExporter() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(new GetStockPriceServiceImpl());
        exporter.setServiceInterface( GetStockPriceService.class );
        return exporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(HessianServer.class, args);
    }

}
