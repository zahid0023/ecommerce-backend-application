package org.example.ecommercebackendapplication.model.dto.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopCategoryDTO {

    private Long id;

    private Long shopId;

    private String name;

    private String description;

    private String logoUrl;
}
