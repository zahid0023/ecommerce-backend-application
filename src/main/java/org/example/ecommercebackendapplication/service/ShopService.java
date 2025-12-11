package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.dto.response.shop.ShopCreateResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopListResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopResponse;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.model.entity.UserEntity;

public interface ShopService {
    ShopCreateResponse createShop(ShopCreateRequest shopCreateRequest, UserEntity userEntity);

    ShopListResponse getShopsOwnedByMerchant(UserEntity userEntity);

    ShopResponse getShopById(Long shopId);

    ShopEntity getShopEntityById(Long shopId);

    Boolean isShopOwnedByMerchant(Long merchantId, Long shopId);
}
