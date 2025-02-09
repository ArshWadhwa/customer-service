package customer.data;

import lombok.Data;

import java.util.List;

@Data
public class AddCustomerRequest {
    String name;
    String email;
    Boolean isActive;
//

}
