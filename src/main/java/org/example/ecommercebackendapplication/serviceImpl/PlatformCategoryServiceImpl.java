package org.example.ecommercebackendapplication.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.example.ecommercebackendapplication.dto.request.category.platform.PlatformCategoryCreateRequest;
import org.example.ecommercebackendapplication.dto.response.category.platform.PlatformCategoryCreateResponse;
import org.example.ecommercebackendapplication.dto.response.category.platform.PlatformCategoryListResponse;
import org.example.ecommercebackendapplication.dto.response.category.platform.PlatformCategoryResponse;
import org.example.ecommercebackendapplication.dto.response.category.platform.RootPlatformCategoryResponse;
import org.example.ecommercebackendapplication.model.dto.shop.PlatformCategoryDTO;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;
import org.example.ecommercebackendapplication.model.mapper.shop.PlatformCategoryMapper;
import org.example.ecommercebackendapplication.repository.PlatformCategoryRepository;
import org.example.ecommercebackendapplication.service.PlatformCategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlatformCategoryServiceImpl implements PlatformCategoryService {
    private final PlatformCategoryRepository platformCategoryRepository;

    public PlatformCategoryServiceImpl(PlatformCategoryRepository platformCategoryRepository) {
        this.platformCategoryRepository = platformCategoryRepository;
    }

    @Override
    public PlatformCategoryCreateResponse createPlatformCategory(PlatformCategoryCreateRequest request) {
        PlatformCategoryEntity parentPlatformCategoryEntity = null;
        if (request.getParentId() != null && request.getParentId() > 0) {
            parentPlatformCategoryEntity = getPlatformCategoryEntity(request.getParentId());
        }

        PlatformCategoryEntity platformCategoryEntity = PlatformCategoryMapper.fromRequest(request, parentPlatformCategoryEntity);
        platformCategoryEntity = platformCategoryRepository.save(platformCategoryEntity);
        PlatformCategoryDTO platformCategoryDTO = PlatformCategoryMapper.fromEntity(platformCategoryEntity);
        return new PlatformCategoryCreateResponse(platformCategoryDTO);
    }

    @Override
    public PlatformCategoryEntity getPlatformCategoryEntity(Long id) {
        return platformCategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PlatformCategory not found"));
    }

    @Override
    public RootPlatformCategoryResponse getRootPlatformCategories() {
        Set<PlatformCategoryEntity> roots = platformCategoryRepository.findAllByParentEntityIsNull();

        Set<PlatformCategoryDTO> platformCategoryDTOS = roots.stream()
                .map(PlatformCategoryMapper::fromEntity)
                .collect(Collectors.toSet());

        return new RootPlatformCategoryResponse(platformCategoryDTOS);
    }

    @Override
    public PlatformCategoryListResponse getImmediateSubCategories(Long categoryId) {
        PlatformCategoryEntity platformCategoryEntity = getPlatformCategoryEntity(categoryId);
        Set<PlatformCategoryEntity> subCategories = platformCategoryRepository.findByParentEntity(platformCategoryEntity);
        Set<PlatformCategoryDTO> platformCategoryDTOS = subCategories.stream()
                .map(PlatformCategoryMapper::fromEntity)
                .collect(Collectors.toSet());
        return new PlatformCategoryListResponse(platformCategoryDTOS);
    }

    @Override
    public PlatformCategoryResponse getPlatformCategory(Long id) {
        PlatformCategoryEntity platformCategoryEntity = getPlatformCategoryEntity(id);
        PlatformCategoryDTO platformCategoryDTO = PlatformCategoryMapper.fromEntityRecursive(platformCategoryEntity);
        return new PlatformCategoryResponse(platformCategoryDTO);
    }
}
