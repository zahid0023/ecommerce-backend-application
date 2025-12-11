package org.example.ecommercebackendapplication.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.dto.response.shop.ShopListResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopCreateResponse;
import org.example.ecommercebackendapplication.dto.response.shop.ShopResponse;
import org.example.ecommercebackendapplication.model.dto.shop.ShopDTO;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.example.ecommercebackendapplication.model.entity.UserEntity;
import org.example.ecommercebackendapplication.model.mapper.shop.ShopMapper;
import org.example.ecommercebackendapplication.model.mapper.shop.ShopOwnerMapper;
import org.example.ecommercebackendapplication.repository.ShopOwnerRepository;
import org.example.ecommercebackendapplication.repository.ShopRepository;
import org.example.ecommercebackendapplication.service.ShopService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ShopOwnerRepository shopOwnerRepository;

    public ShopServiceImpl(ShopRepository shopRepository, ShopOwnerRepository shopOwnerRepository) {
        this.shopRepository = shopRepository;
        this.shopOwnerRepository = shopOwnerRepository;
    }

    @Override
    @Transactional
    public ShopCreateResponse createShop(ShopCreateRequest shopCreateRequest, UserEntity userEntity) {
        ShopEntity shopEntity = ShopMapper.fromRequest(shopCreateRequest);
        shopEntity = shopRepository.save(shopEntity);

        ShopOwnerEntity shopOwnerEntity = ShopOwnerMapper.fromRequest(userEntity, shopEntity, "SHOP_OWNER");
        shopOwnerRepository.save(shopOwnerEntity);

        ShopDTO shopDTO = ShopMapper.toDTO(shopEntity);
        return new ShopCreateResponse(shopDTO);
    }

    @Override
    public ShopResponse getShopById(Long shopId) {
        ShopEntity shopEntity = getShopEntityById(shopId);
        ShopDTO shopDTO = ShopMapper.toDTO(shopEntity);
        return new ShopResponse(shopDTO);
    }

    @Override
    public ShopListResponse getShopsOwnedByMerchant(UserEntity userEntity) {
        return null;
    }

    @Override
    public ShopEntity getShopEntityById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException("ShopEntity Not Found!! "));
    }

    @Override
    public Boolean isShopOwnedByMerchant(Long merchantId, Long shopId) {
        return shopOwnerRepository.isShopOwnedByMerchant(merchantId, shopId);
    }
}
