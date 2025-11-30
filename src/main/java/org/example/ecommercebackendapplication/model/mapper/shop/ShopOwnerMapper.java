package org.example.ecommercebackendapplication.model.mapper.shop;

import lombok.experimental.UtilityClass;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.example.ecommercebackendapplication.model.entity.UserEntity;

@UtilityClass
public class ShopOwnerMapper {
    public static ShopOwnerEntity fromRequest(UserEntity userEntity, ShopEntity shopEntity, String role) {
        ShopOwnerEntity shopOwnerEntity = new ShopOwnerEntity();
        shopOwnerEntity.setOwnerEntity(userEntity);
        shopOwnerEntity.setShopEntity(shopEntity);
        shopOwnerEntity.setRole(role);
        return shopOwnerEntity;
    }
}
