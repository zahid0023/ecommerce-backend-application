package org.example.ecommercebackendapplication.dto.response.category.platform;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.ecommercebackendapplication.model.dto.shop.PlatformCategoryDTO;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlatformCategoryResponse {
    private final PlatformCategoryDTO data;

    public PlatformCategoryResponse(final PlatformCategoryDTO data) {
        this.data = data;
    }
}
