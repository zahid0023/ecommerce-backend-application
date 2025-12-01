package org.example.ecommercebackendapplication.model.mapper.shop;

import lombok.experimental.UtilityClass;
import org.example.ecommercebackendapplication.dto.request.category.platform.PlatformCategoryCreateRequest;
import org.example.ecommercebackendapplication.model.dto.shop.PlatformCategoryDTO;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;

import java.util.stream.Collectors;

@UtilityClass
public class PlatformCategoryMapper {
    public static PlatformCategoryEntity fromRequest(PlatformCategoryCreateRequest request, PlatformCategoryEntity platformCategoryEntity) {
        PlatformCategoryEntity entity = new PlatformCategoryEntity();
        entity.setParentEntity(platformCategoryEntity);
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLogoUrl(request.getLogoUrl());
        return entity;
    }

    public static PlatformCategoryDTO fromEntity(PlatformCategoryEntity entity) {
        return PlatformCategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .logoUrl(entity.getLogoUrl())
                .build();
    }

    /**
     * Recursive mapping: includes parent nested subcategories
     */
    public static PlatformCategoryDTO fromEntityRecursive(PlatformCategoryEntity entity) {
        return PlatformCategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .logoUrl(entity.getLogoUrl())
                .subCategories(entity.getSubCategories() != null && !entity.getSubCategories().isEmpty()
                        ? entity.getSubCategories().stream()
                        .map(PlatformCategoryMapper::fromEntityRecursive) // recursive call
                        .collect(Collectors.toSet())
                        : null)
                .build();
    }
}