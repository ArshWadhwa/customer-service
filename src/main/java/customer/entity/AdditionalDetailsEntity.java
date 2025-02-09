package customer.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(name = "additional_details")
public class AdditionalDetailsEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;  // ✅ Correctly mapped to your table schema

    @Column(nullable = false, name = "user_id")
    private UUID userId;  // ✅ Matches your schema

    @Column(nullable = false, length = 255, name = "attribute_key")
    private String attributeKey;

    @Column(length = 255, name = "attribute_value")
    private String attributeValue;

    @Column(nullable = false, name = "is_encrypted")
    private boolean isEncrypted = true;

    @Column(updatable = false, name = "created_at")
    private Instant createdAt;

    @Column(nullable = false, name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        if (id == null) { // Ensure UUID is assigned before saving
            id = UUID.randomUUID();
        }
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }
}
