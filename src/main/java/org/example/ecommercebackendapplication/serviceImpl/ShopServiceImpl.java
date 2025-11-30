package org.example.ecommercebackendapplication.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.dto.response.shop.AllShopsResponse;
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

import java.util.List;

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
    public AllShopsResponse getAllShops(ShopOwnerEntity shopOwnerEntity) {
        List<ShopEntity> shopEntities = List.of();
        List<ShopDTO> shopDTOList = shopEntities.stream()
                .map(ShopMapper::toDTO)
                .toList();
        return new AllShopsResponse(shopDTOList);
    }

    @Override
    public ShopResponse getShopById(Long shopId) {
        ShopEntity shopEntity = shopRepository.findById(shopId).orElseThrow(() -> new EntityNotFoundException(""));
        ShopDTO shopDTO = ShopMapper.toDTO(shopEntity);
        return new ShopResponse(shopDTO);
    }
}
