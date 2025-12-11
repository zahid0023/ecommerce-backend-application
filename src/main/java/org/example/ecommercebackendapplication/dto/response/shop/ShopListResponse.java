package org.example.ecommercebackendapplication.dto.response.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.ecommercebackendapplication.model.dto.shop.ShopDTO;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopListResponse {
    private List<ShopDTO> data;

    public ShopListResponse(List<ShopDTO> shops) {
        this.data = shops;
    }
}
