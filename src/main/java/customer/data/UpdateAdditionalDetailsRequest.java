package customer.data;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class UpdateAdditionalDetailsRequest {


    @NotNull(message = "userId is required")
    private UUID userId;

    @NotBlank(message = "attributeKey is required")
    private String attributeKey;

    @NotBlank(message = "attributeValue is required")
    private String updatedAttributeValue;
}
