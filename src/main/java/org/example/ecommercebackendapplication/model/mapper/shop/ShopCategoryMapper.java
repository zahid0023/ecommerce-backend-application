package org.example.ecommercebackendapplication.model.mapper.shop;

import org.example.ecommercebackendapplication.dto.request.category.CategoryCreateRequest;
import org.example.ecommercebackendapplication.model.dto.shop.ShopCategoryDTO;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import lombok.experimental.UtilityClass;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;

@UtilityClass
public class ShopCategoryMapper {

    public static ShopCategoryEntity fromRequest(CategoryCreateRequest request, ShopEntity shopEntity) {
        ShopCategoryEntity shopCategoryEntity = new ShopCategoryEntity();
        shopCategoryEntity.setShop(shopEntity);
        shopCategoryEntity.setName(request.getName());
        shopCategoryEntity.setDescription(request.getDescription());
        shopCategoryEntity.setLogoUrl(request.getLogoUrl());
        return shopCategoryEntity;
    }

    public static ShopCategoryDTO toDTO(ShopCategoryEntity entity) {
        return ShopCategoryDTO.builder()
                .id(entity.getId())
                .shopId(entity.getShop().getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .logoUrl(entity.getLogoUrl())
                .build();
    }
}
