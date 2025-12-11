package org.example.ecommercebackendapplication.model.mapper.shop;

import lombok.experimental.UtilityClass;
import org.example.ecommercebackendapplication.dto.request.category.shop.ShopCategoryRequest;
import org.example.ecommercebackendapplication.model.dto.shop.ShopCategoryDTO;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;

@UtilityClass
public class ShopCategoryMapper {
    public static ShopCategoryEntity fromRequest(ShopCategoryRequest request,
                                                 ShopCategoryEntity shopCategoryEntity,
                                                 PlatformCategoryEntity platformCategoryEntity,
                                                 ShopEntity shopEntity) {
        ShopCategoryEntity entity = new ShopCategoryEntity();
        entity.setShopEntity(shopEntity);
        entity.setParentEntity(shopCategoryEntity);
        entity.setPlatformCategoryEntity(platformCategoryEntity);
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLogoUrl(request.getLogoUrl());
        return entity;
    }

    public static ShopCategoryDTO toDTO(ShopCategoryEntity entity) {
        return ShopCategoryDTO.builder()
                .id(entity.getId())
                .shopId(entity.getShopEntity().getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .logoUrl(entity.getLogoUrl())
                .build();
    }
}
