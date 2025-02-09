package customer.service.impl;

import customer.data.AdditionalDetailsRequest;
import customer.data.Customer;
import customer.data.db.AdditionalDetailDbRepository;
import customer.entity.AdditionalDetailsEntity;
import customer.entity.CustomerEntity;
import customer.service.AdditionalDetailsService;
import customer.service.CustomerService;
import customer.service.impl.db.AdditionalDetailsDbServiceImpl;
import customer.service.impl.db.CustomerDbServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AdditionalDetailsServiceImpl implements AdditionalDetailsService{


    private final AdditionalDetailsDbServiceImpl additionalDetailsDbService;
    private final CustomerDbServiceImpl customerDbService;

    public AdditionalDetailsServiceImpl(AdditionalDetailsDbServiceImpl additionalDetailsDbService, CustomerDbServiceImpl customerDbService) {
        this.additionalDetailsDbService = additionalDetailsDbService;
        this.customerDbService = customerDbService;
    }

    @Override
    @Transactional
    public void addAdditionalDetails(AdditionalDetailsRequest additionalDetailsRequest){
        Optional<CustomerEntity> customerEntity=customerDbService.getCustomerEntity(additionalDetailsRequest.getUserId());
        if(customerEntity.isPresent()){
            additionalDetailsDbService.saveAdditionalDetails(additionalDetailsRequest,customerEntity.get());


        }



    }



}
