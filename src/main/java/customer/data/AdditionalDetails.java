package customer.data;

import lombok.Data;

import java.util.UUID;
@Data
public class AdditionalDetails {
    UUID userId;
    String attributeKey;
    String attributeValue;
    Boolean isEncrypted;
}
