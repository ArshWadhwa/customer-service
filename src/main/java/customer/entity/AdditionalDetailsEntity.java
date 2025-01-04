package customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(name = "additional_details")
public class AdditionalDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID user_id;

    @Column(nullable = false, length = 255,name = "attribute_key")
    private String attribute_key;

    @Column(nullable = false, length = 255,name = "attribute_value")
    private String attributeValue;

    @Column(nullable = false, name="is_encrypted")
    private boolean isEncrypted;

    @Column(updatable = false,name = "created_at")
    private Instant createdAt;

    @Column(nullable = false,name = "updated_at")
    private Instant updatedAt;
}
