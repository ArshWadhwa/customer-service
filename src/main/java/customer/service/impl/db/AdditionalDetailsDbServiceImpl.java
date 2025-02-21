package customer.service.impl.db;

import customer.data.AdditionalDetail;
import customer.data.AdditionalDetailsRequest;
import customer.data.Customer;
import customer.data.UpdateAdditionalDetailsRequest;
import customer.data.db.AdditionalDetailDbRepository;
import customer.entity.AdditionalDetailsEntity;
import customer.entity.CustomerEntity;
import customer.service.AdditionalDetailsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class AdditionalDetailsDbServiceImpl {

    private final AdditionalDetailDbRepository additionalDetailDbRepository;
    private final CustomerDbServiceImpl customerDbService;

    public AdditionalDetailsDbServiceImpl(AdditionalDetailDbRepository additionalDetailDbRepository, CustomerDbServiceImpl customerDbService) {
        this.additionalDetailDbRepository = additionalDetailDbRepository;
        this.customerDbService = customerDbService;
    }


    @Transactional
    public void saveAdditionalDetails(AdditionalDetailsRequest additionalDetailsRequest, CustomerEntity customerEntity) {


//        Optional<Customer> customer
        List<AdditionalDetailsEntity> additionalDetailsEntities=new ArrayList<>();


        additionalDetailsRequest.getAdditionalDetails().forEach(item ->{
            AdditionalDetailsEntity additionalDetails = new AdditionalDetailsEntity();
            additionalDetails.setAttributeKey(item.getAttributeKey());
            additionalDetails.setAttributeValue(item.getAttributeValue());
            additionalDetails.setEncrypted(true);
           additionalDetails.setUserId(customerEntity.getId());
            additionalDetails.setUpdatedAt(Instant.now());
            additionalDetails.setCreatedAt(Instant.now());
          additionalDetailsEntities.add(additionalDetails);
        });


//        additionalDetailsEntity.setAttributeValue(additionalDetailsRequest);
//        additionalDetailsEntity.setAttribute_key(additionalDetailsRequest.getAttributeKey());


    additionalDetailDbRepository.saveAll(additionalDetailsEntities);
}
@Transactional
public void updateAdditionalDetails(UpdateAdditionalDetailsRequest updateAdditionalDetailsRequest){
    List<AdditionalDetailsEntity> optionalDetail = additionalDetailDbRepository.findByUserId(updateAdditionalDetailsRequest.getUserId());

if(optionalDetail.isEmpty()) {
    throw new EntityNotFoundException("No additionalDetails found" + updateAdditionalDetailsRequest.getUserId());

}
    for (AdditionalDetailsEntity detail :optionalDetail) {
        detail.setAttributeKey(updateAdditionalDetailsRequest.getUpdatedAttributeKey());
        detail.setAttributeValue(updateAdditionalDetailsRequest.getUpdatedAttributeValue());
        detail.setUpdatedAt(Instant.now());
    }
    additionalDetailDbRepository.saveAll(optionalDetail);


}

}
