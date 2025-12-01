package org.example.ecommercebackendapplication.model.dto.shop;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlatformCategoryDTO {

    private Long id;

    private String name;

    private String description;

    private String logoUrl;

    private Set<PlatformCategoryDTO> subCategories;
}
