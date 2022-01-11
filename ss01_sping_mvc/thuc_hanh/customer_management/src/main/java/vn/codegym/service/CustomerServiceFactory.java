package vn.codegym.service;

import vn.codegym.service.imp.SimpleCustomerServiceImpl;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
