package customer.service;

import customer.data.AddCustomerRequest;
import customer.data.Customer;
import customer.data.DeleteCustomerRequest;
import customer.data.UpdateCustomerRequest;

public interface CustomerService {
    String addCustomer(AddCustomerRequest addCustomerRequest);
    Customer getCustomer(String userId);

    void updateCustomer(UpdateCustomerRequest updateCustomerRequest);

    void deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);
}
