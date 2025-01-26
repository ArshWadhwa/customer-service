package customer.service;

import customer.data.*;

public interface CustomerService {
    String addCustomer(AddCustomerRequest addCustomerRequest);
    Customer getCustomer(String userId);

    void updateCustomer(UpdateCustomerRequest updateCustomerRequest);
//    void addCustomer(AddCustomerRequest addCustomerRequest);
    void deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);



}
