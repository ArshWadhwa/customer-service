package customer.data;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateCustomerRequest {
    UUID id;
    String updatedName;
    String updatedEmail;
    Boolean updatedIsActive;

}
