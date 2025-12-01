package org.example.ecommercebackendapplication.dto.request.category.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopCategoryRequest {
    private Long platformCategoryId;
    private Long parentId;
    private String name;
    private String description;
    private String logoUrl;
}
