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
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<AdditionalDetailsEntity> additionalDetails; // For bi-directional mapping

    @Column(updatable = false, name = "created_at")
    private Instant createdAt;

    @Column(nullable = false, name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }
}
