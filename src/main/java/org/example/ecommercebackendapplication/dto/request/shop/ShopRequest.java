package org.example.ecommercebackendapplication.dto.request.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopRequest {

    @NotBlank
    @Size(max = 150)
    private String shopName;

    @NotBlank
    @Size(max = 200)
    private String shopSlug;

    @NotBlank
    private String description;

    @NotBlank
    private String logoUrl;
}
