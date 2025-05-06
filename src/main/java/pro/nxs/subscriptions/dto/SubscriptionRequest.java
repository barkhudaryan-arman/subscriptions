package pro.nxs.subscriptions.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubscriptionRequest {
    @NotBlank
    private String serviceName;
}
