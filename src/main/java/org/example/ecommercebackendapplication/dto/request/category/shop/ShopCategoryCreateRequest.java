package org.example.ecommercebackendapplication.dto.request.category.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.ecommercebackendapplication.dto.request.category.platform.PlatformCategoryRequest;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShopCategoryCreateRequest extends ShopCategoryRequest {
    private Long shopId;
    private List<ShopCategoryRequest> categories;
}
