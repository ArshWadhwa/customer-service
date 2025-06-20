package customer.service;

import customer.data.AdditionalDetailsRequest;
import customer.data.UpdateAdditionalDetailsRequest;

public interface AdditionalDetailsService {
    void addAdditionalDetails(AdditionalDetailsRequest additionalDetailsRequest);
      void updateAdditionalDetails(UpdateAdditionalDetailsRequest updateAdditionalDetailsRequest);
}
