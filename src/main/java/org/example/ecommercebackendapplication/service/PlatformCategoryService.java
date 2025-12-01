package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.category.platform.PlatformCategoryCreateRequest;
import org.example.ecommercebackendapplication.dto.response.category.platform.PlatformCategoryCreateResponse;
import org.example.ecommercebackendapplication.dto.response.category.platform.PlatformCategoryListResponse;
import org.example.ecommercebackendapplication.dto.response.category.platform.PlatformCategoryResponse;
import org.example.ecommercebackendapplication.dto.response.category.platform.RootPlatformCategoryResponse;
import org.example.ecommercebackendapplication.model.dto.shop.PlatformCategoryDTO;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;

public interface PlatformCategoryService {
    PlatformCategoryCreateResponse createPlatformCategory(PlatformCategoryCreateRequest request);

    PlatformCategoryEntity getPlatformCategoryEntity(Long id);

    RootPlatformCategoryResponse getRootPlatformCategories();

    PlatformCategoryListResponse getImmediateSubCategories(Long categoryId);

    PlatformCategoryResponse getPlatformCategory(Long id);

}
