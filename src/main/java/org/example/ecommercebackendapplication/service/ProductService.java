package org.example.ecommercebackendapplication.service;

import org.example.ecommercebackendapplication.dto.request.product.CreateProductRequest;
import org.example.ecommercebackendapplication.dto.response.product.CreateProductResponse;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;

public interface ProductService {
    CreateProductResponse createProduct(CreateProductRequest request, ShopEntity shopEntity, ShopCategoryEntity shopCategoryEntity);
}
