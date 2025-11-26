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
import org.example.ecommercebackendapplication.model.mapper.shop.ShopMapper;
import org.example.ecommercebackendapplication.repository.ShopRepository;
import org.example.ecommercebackendapplication.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    @Transactional
    public ShopCreateResponse createShop(ShopCreateRequest shopCreateRequest, ShopOwnerEntity shopOwnerEntity) {
        ShopEntity shopEntity = ShopMapper.fromRequest(shopCreateRequest, shopOwnerEntity);
        shopEntity = shopRepository.save(shopEntity);
        ShopDTO shopDTO = ShopMapper.toDTO(shopEntity);
        return new ShopCreateResponse(shopDTO);
    }

    @Override
    public AllShopsResponse getAllShops(ShopOwnerEntity shopOwnerEntity) {
        List<ShopEntity> shopEntities = shopRepository.findAllByShopOwnerEntity(shopOwnerEntity);
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
