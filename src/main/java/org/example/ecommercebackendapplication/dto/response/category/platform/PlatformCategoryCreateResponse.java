package org.example.ecommercebackendapplication.dto.response.category.platform;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.ecommercebackendapplication.model.dto.shop.PlatformCategoryDTO;
import org.example.ecommercebackendapplication.model.dto.shop.ShopCategoryDTO;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlatformCategoryCreateResponse {
    private final PlatformCategoryDTO data;

    public PlatformCategoryCreateResponse(PlatformCategoryDTO data) {
        this.data = data;
    }
}
