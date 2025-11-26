package org.example.ecommercebackendapplication.repository;

import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCategoryRepository extends JpaRepository<ShopCategoryEntity, Long> {
}   
