package org.example.ecommercebackendapplication.dto.response.category.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.ecommercebackendapplication.model.dto.shop.ShopCategoryDTO;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateShopCategoryResponse {
    private final ShopCategoryDTO data;

    public CreateShopCategoryResponse(ShopCategoryDTO data) {
        this.data = data;
    }
}
