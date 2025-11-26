package org.example.ecommercebackendapplication.repository;

import jakarta.validation.constraints.NotNull;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopOwnerRepository extends JpaRepository<ShopOwnerEntity, Long> {
    Optional<ShopOwnerEntity> findByUsername(@NotNull String username);
}
