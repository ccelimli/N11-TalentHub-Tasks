package org.n11;

import org.n11.service.Imp.*;
import org.n11.service.SystemService;

public class Main {
    public static void main(String[] args) {
        SystemServiceImp systemServiceImp= new SystemServiceImp(new CustomerServiceImp(),new OrderServiceImp(new ProductServiceImp()), new ProductServiceImp(),new InvoiceServiceImp(new OrderServiceImp(new ProductServiceImp())));
        systemServiceImp.start();
    }
}