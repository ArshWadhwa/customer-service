package customer.service.impl.db;

import customer.controller.CustomerController;
import customer.data.Customer;
import customer.data.db.CustomerDbRepository;
import customer.entity.CustomerEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.id.enhanced.CustomOptimizerDescriptor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerDbServiceImpl {

    private static final Logger logger = LogManager.getLogger(CustomerDbServiceImpl.class);
    private final CustomerDbRepository customerDbRepository;

    public CustomerDbServiceImpl(CustomerDbRepository customerDbRepository) {
        this.customerDbRepository = customerDbRepository;
    }

    public void addCustomer(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setIsActive(customer.getIsActive());
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setUpdatedAt(Instant.now());
        customerEntity.setCreatedAt(Instant.now());
        logger.info("Saving customer in DB with entity {}",customerEntity);
        customerDbRepository.save(customerEntity);
    }

    public Customer  GetCustomerByUserId(UUID userId){
        Optional<CustomerEntity> optionalCustomerEntity = customerDbRepository.findById(userId);
        if(optionalCustomerEntity!=null){
            Customer customer=new Customer();
            CustomerEntity customerEntity=optionalCustomerEntity.get();
                customer.setId(customerEntity.getId());
                customer.setName(customerEntity.getName());
                customer.setEmail(customerEntity.getEmail());
                customer.setIsActive(customerEntity.getIsActive());

            return customer;
        }
        return null;

    }

    public void updatedCustomerInDb(Customer customer){
        Optional<CustomerEntity> optionalCustomerEntity=customerDbRepository.findById(customer.getId());
        if(optionalCustomerEntity.isPresent()){
           CustomerEntity customerEntity=optionalCustomerEntity.get();
           customerEntity.setName(customer.getName());
           customerEntity.setEmail(customer.getEmail());
           customerEntity.setIsActive(customer.getIsActive());
           customerEntity.setUpdatedAt(Instant.now());

customerDbRepository.save(customerEntity);


        }else{
            throw new RuntimeException("customer not found for id : "+customer.getId());
        }



        }
    public void deleteCustomerByUserId(UUID customerId){
        Optional<CustomerEntity> optionalCustomerEntity = customerDbRepository.findById(customerId);
        if(optionalCustomerEntity.isPresent()){
            customerDbRepository.deleteById(customerId);
            logger.info("Customer Id with : "+customerId);
        }else{
            throw new RuntimeException("This id not found"+customerId);
        }
    }
}
