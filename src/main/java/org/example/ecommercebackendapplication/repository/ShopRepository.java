package org.example.ecommercebackendapplication.repository;

import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
}
