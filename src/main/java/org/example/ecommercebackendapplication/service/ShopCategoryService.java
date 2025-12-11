package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.category.shop.ShopCategoryCreateRequest;
import org.example.ecommercebackendapplication.dto.response.category.shop.CreateShopCategoryResponse;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;

public interface ShopCategoryService {
    CreateShopCategoryResponse createShopCategory(ShopCategoryCreateRequest request,
                                                  ShopEntity shopEntity,
                                                  ShopCategoryEntity parentCategoryEntity,
                                                  PlatformCategoryEntity platformCategoryEntity);

    ShopCategoryEntity getShopCategoryEntity(Long id);
}
