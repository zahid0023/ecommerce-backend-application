package org.example.ecommercebackendapplication.dto.response.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.ecommercebackendapplication.model.dto.shop.ShopDTO;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopCreateResponse {
    private ShopDTO data;

    public ShopCreateResponse(ShopDTO data) {
        this.data = data;
    }
}
