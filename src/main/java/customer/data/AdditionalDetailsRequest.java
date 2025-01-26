package customer.data;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class AdditionalDetailsRequest {
    private UUID userId;
    private String attributeKey;
    private String attributeValue;

//    Boolean isEncrypted;
}
