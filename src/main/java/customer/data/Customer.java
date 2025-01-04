package customer.data;


import lombok.Data;

import java.util.UUID;

@Data
public class Customer {
    UUID id;
    String name;
    String email;
    Boolean isActive;
}
