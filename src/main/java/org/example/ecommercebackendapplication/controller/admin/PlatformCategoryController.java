package org.example.ecommercebackendapplication.controller.admin;

import org.example.ecommercebackendapplication.dto.request.category.platform.PlatformCategoryCreateRequest;
import org.example.ecommercebackendapplication.service.PlatformCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/categories")
public class PlatformCategoryController {
    private final PlatformCategoryService platformCategoryService;

    public PlatformCategoryController(final PlatformCategoryService platformCategoryService) {
        this.platformCategoryService = platformCategoryService;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody PlatformCategoryCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(platformCategoryService.createPlatformCategory(request));
    }
}
