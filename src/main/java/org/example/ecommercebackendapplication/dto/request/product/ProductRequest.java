package org.example.ecommercebackendapplication.dto.request.product;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductRequest {
    private Long shopId;

    private Long categoryId;

    private String name;

    private String highlights;

    private BigDecimal basePrice;

    private BigDecimal sellingPrice;
}
