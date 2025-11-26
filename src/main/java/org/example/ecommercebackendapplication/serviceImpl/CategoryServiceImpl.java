package org.example.ecommercebackendapplication.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.category.CategoryCreateRequest;
import org.example.ecommercebackendapplication.dto.response.category.CategoryCreateResponse;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.repository.ShopCategoryRepository;
import org.example.ecommercebackendapplication.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final ShopCategoryRepository shopCategoryRepository;

    public CategoryServiceImpl(ShopCategoryRepository shopCategoryRepository) {
        this.shopCategoryRepository = shopCategoryRepository;
    }

    @Override
    public CategoryCreateResponse createShopCategory(CategoryCreateRequest request, ShopEntity shopEntity) {
        return null;
    }
}
