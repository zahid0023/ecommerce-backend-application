package org.example.ecommercebackendapplication.dto.response.category.platform;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.ecommercebackendapplication.model.dto.shop.PlatformCategoryDTO;
import java.util.Set;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlatformCategoryListResponse {
    private final Set<PlatformCategoryDTO> data;
    public PlatformCategoryListResponse(Set<PlatformCategoryDTO> data) {
        this.data = data;
    }
}
