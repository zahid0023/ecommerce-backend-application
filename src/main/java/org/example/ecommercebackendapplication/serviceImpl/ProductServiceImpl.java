package org.example.ecommercebackendapplication.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.product.CreateProductRequest;
import org.example.ecommercebackendapplication.dto.response.product.CreateProductResponse;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public CreateProductResponse createProduct(CreateProductRequest request, ShopEntity shopEntity, ShopCategoryEntity shopCategoryEntity) {
        return null;
    }
}
