package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.dto.response.shop.AllShopsResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopCreateResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopResponse;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;

public interface ShopService {
    ShopCreateResponse createShop(ShopCreateRequest shopCreateRequest, ShopOwnerEntity shopOwnerEntity);

    AllShopsResponse getAllShops(ShopOwnerEntity shopOwnerEntity);

    ShopResponse getShopById(Long shopId);
}
