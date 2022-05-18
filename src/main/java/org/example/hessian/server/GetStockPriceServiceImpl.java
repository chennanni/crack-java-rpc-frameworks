package org.example.hessian.server;

import org.example.hessian.core.GetStockPriceService;
import org.springframework.util.StringUtils;

import java.util.HashMap;

public class GetStockPriceServiceImpl implements GetStockPriceService {

    private static final HashMap<String, Double> stockMap = new HashMap<>();
    static{
        stockMap.put("apple", 150d);
        stockMap.put("amazon", 2200d);
        stockMap.put("google", 2330d);
    }

    @Override
    public double getStockPrice(String stockName) {
        double result = -1d;
        if (!StringUtils.isEmpty(stockName) && stockMap.containsKey(stockName)){
            result = stockMap.get(stockName);
        }
        return result;
    }

}
