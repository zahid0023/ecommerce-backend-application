package org.example.ecommercebackendapplication.repository;

import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PlatformCategoryRepository extends JpaRepository<PlatformCategoryEntity, Long> {
    Set<PlatformCategoryEntity> findAllByParentEntityIsNull();

    Set<PlatformCategoryEntity> findByParentEntity(PlatformCategoryEntity parentEntity);
}
