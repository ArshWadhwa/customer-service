package customer.service.impl;

import customer.service.AdditionalDetailsService;
import customer.service.impl.db.AdditionalDetailsDbServiceImpl;
import customer.service.impl.db.CustomerDbServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class AdditionalDetailsServiceImpl implements AdditionalDetailsService {
    private CustomerDbServiceImpl customerDbService;


    public AdditionalDetailsServiceImpl(CustomerDbServiceImpl customerDbService) {
        this.customerDbService = customerDbService;
    }

    @Override
    public void addAdditionalDetails() {

    }
}
