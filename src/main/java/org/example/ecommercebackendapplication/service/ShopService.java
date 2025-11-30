package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.dto.response.shop.AllShopsResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopCreateResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopResponse;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.example.ecommercebackendapplication.model.entity.UserEntity;

public interface ShopService {
    ShopCreateResponse createShop(ShopCreateRequest shopCreateRequest, UserEntity userEntity);

    AllShopsResponse getAllShops(ShopOwnerEntity shopOwnerEntity);

    ShopResponse getShopById(Long shopId);
}
