package org.example.ecommercebackendapplication.repository;

import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopOwnerRepository extends JpaRepository<ShopOwnerEntity, Long> {
    // Fetch all shops owned by a given merchant
    @Query("SELECT so.shopEntity FROM ShopOwnerEntity so WHERE so.ownerEntity.id = :ownerId")
    List<ShopEntity> findAllShopsByOwnerId(@Param("ownerId") Long ownerId);

    @Query("""
                SELECT COUNT(so) > 0
                FROM ShopOwnerEntity so
                WHERE so.ownerEntity.id = :merchantId
                  AND so.shopEntity.id = :shopId
            """)
    boolean isShopOwnedByMerchant(@Param("merchantId") Long merchantId,
                                  @Param("shopId") Long shopId);

}