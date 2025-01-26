package customer.data;


import customer.entity.AdditionalDetailsEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Customer {
    UUID id;
    String name;
    String email;
    Boolean isActive;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<AdditionalDetailsEntity> additionalDetailsEntity = new ArrayList<>();
}
