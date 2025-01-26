package customer.service.impl.db;

import customer.data.AdditionalDetailsRequest;
import customer.data.db.AdditionalDetailDbRepository;
import customer.entity.AdditionalDetailsEntity;
import customer.service.AdditionalDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class AdditionalDetailsDbServiceImpl {

    private final AdditionalDetailDbRepository additionalDetailDbRepository;
    private final CustomerDbServiceImpl customerDbService;

    public AdditionalDetailsDbServiceImpl(AdditionalDetailDbRepository additionalDetailDbRepository, CustomerDbServiceImpl customerDbService) {
        this.additionalDetailDbRepository = additionalDetailDbRepository;
        this.customerDbService = customerDbService;
    }


    @Transactional
    public void saveAdditionalDetails(AdditionalDetailsRequest additionalDetailsRequest) {
//        Optional<Customer> customer
        AdditionalDetailsEntity additionalDetailsEntity = new AdditionalDetailsEntity();


        additionalDetailsEntity.setAttributeValue(additionalDetailsRequest.getAttributeValue());
        additionalDetailsEntity.setAttribute_key(additionalDetailsRequest.getAttributeKey());

    additionalDetailDbRepository.save(additionalDetailsEntity);
}
}
