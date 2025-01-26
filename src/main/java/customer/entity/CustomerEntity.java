package customer.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, name = "is_active")
    private Boolean isActive;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<AdditionalDetailsEntity> additionalDetails;

    @Column(updatable = false, name = "created_at")
    private Instant createdAt;

    @Column(nullable = false, name = "updated_at")
    private Instant updatedAt;
}