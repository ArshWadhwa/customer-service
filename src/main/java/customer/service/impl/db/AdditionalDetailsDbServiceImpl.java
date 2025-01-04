package customer.service.impl.db;

import customer.data.db.AdditionalDetailDbRepository;
import customer.service.AdditionalDetailsService;

public class AdditionalDetailsDbServiceImpl {

    private AdditionalDetailDbRepository additionalDetailDbRepository;

    public AdditionalDetailsDbServiceImpl(AdditionalDetailDbRepository additionalDetailDbRepository) {
        this.additionalDetailDbRepository = additionalDetailDbRepository;
    }



}
