package org.example.ecommercebackendapplication.model.mapper.shop;

import lombok.experimental.UtilityClass;
import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.model.dto.shop.ShopDTO;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;

@UtilityClass
public class ShopMapper {
    public static ShopEntity fromRequest(ShopCreateRequest request) {
        ShopEntity entity = new ShopEntity();
        entity.setShopName(request.getShopName());
        entity.setShopSlug(request.getShopSlug());
        entity.setDescription(request.getDescription());
        entity.setLogoUrl(request.getLogoUrl());
        entity.setIsActive(false);
        return entity;
    }

    public static ShopDTO toDTO(ShopEntity entity) {
        ShopDTO dto = new ShopDTO();
        dto.setId(entity.getId());
        dto.setShopName(entity.getShopName());
        dto.setShopSlug(entity.getShopSlug());
        dto.setDescription(entity.getDescription());
        dto.setLogoUrl(entity.getLogoUrl());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }
}
