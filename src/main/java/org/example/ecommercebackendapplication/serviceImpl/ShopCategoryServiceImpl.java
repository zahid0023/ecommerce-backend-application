package org.example.ecommercebackendapplication.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.category.shop.ShopCategoryCreateRequest;
import org.example.ecommercebackendapplication.dto.response.category.shop.CreateShopCategoryResponse;
import org.example.ecommercebackendapplication.model.dto.shop.ShopCategoryDTO;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.model.mapper.shop.ShopCategoryMapper;
import org.example.ecommercebackendapplication.repository.ShopCategoryRepository;
import org.example.ecommercebackendapplication.service.ShopCategoryService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShopCategoryServiceImpl implements ShopCategoryService {
    private final ShopCategoryRepository shopCategoryRepository;

    public ShopCategoryServiceImpl(ShopCategoryRepository shopCategoryRepository) {
        this.shopCategoryRepository = shopCategoryRepository;
    }

    @Override
    public CreateShopCategoryResponse createShopCategory(ShopCategoryCreateRequest request,
                                                         ShopEntity shopEntity,
                                                         ShopCategoryEntity parentCategoryEntity,
                                                         PlatformCategoryEntity platformCategoryEntity) {
        ShopCategoryEntity shopCategoryEntity = ShopCategoryMapper.fromRequest(request, parentCategoryEntity, platformCategoryEntity, shopEntity);
        shopCategoryEntity = shopCategoryRepository.save(shopCategoryEntity);
        ShopCategoryDTO shopCategoryDTO = ShopCategoryMapper.toDTO(shopCategoryEntity);
        return new CreateShopCategoryResponse(shopCategoryDTO);
    }

    @Override
    public ShopCategoryEntity getShopCategoryEntity(Long id) {
            return shopCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("ShopCategory not found"));
    }
}
