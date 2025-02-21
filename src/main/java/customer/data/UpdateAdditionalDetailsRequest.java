package customer.data;

import lombok.Data;

import java.util.UUID;
@Data
public class UpdateAdditionalDetailsRequest {
    private UUID userId;
    private String updatedAttributeKey;
    private String updatedAttributeValue;

}
