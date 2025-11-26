package org.example.ecommercebackendapplication.model.dto.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopDTO {

    private Long id;

    private String shopName;

    private String shopSlug;

    private String description;

    private String logoUrl;

    private Boolean isActive;
}
