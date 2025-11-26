package org.example.ecommercebackendapplication.dto.response.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SuccessResponse {
    private final Boolean success;
    public SuccessResponse(final Boolean success) {
        this.success = success;
    }
}
