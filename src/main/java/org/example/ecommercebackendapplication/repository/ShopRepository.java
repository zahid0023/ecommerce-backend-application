package org.example.ecommercebackendapplication.repository;

import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
    List<ShopEntity> findAllByShopOwnerEntity(ShopOwnerEntity shopOwnerEntity);
}
