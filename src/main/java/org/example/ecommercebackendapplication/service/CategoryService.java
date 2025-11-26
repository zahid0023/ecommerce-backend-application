package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.category.CategoryCreateRequest;
import org.example.ecommercebackendapplication.dto.response.category.CategoryCreateResponse;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;

public interface CategoryService {
    CategoryCreateResponse createShopCategory(CategoryCreateRequest request, ShopEntity shopEntity);
}
