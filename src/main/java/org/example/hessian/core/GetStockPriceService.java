package org.example.hessian.core;

// service interface shard by the client and server
public interface GetStockPriceService {

    double getStockPrice(String stockName);
}
