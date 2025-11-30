package org.example.ecommercebackendapplication.repository;

import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopOwnerRepository extends JpaRepository<ShopOwnerEntity, Long> {
}
