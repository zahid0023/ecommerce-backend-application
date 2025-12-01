package org.example.ecommercebackendapplication.controller.shopowner;

import org.example.ecommercebackendapplication.service.PlatformCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchants/categories")
public class ShopCategoryController {
    private final PlatformCategoryService platformCategoryService;

    public ShopCategoryController(PlatformCategoryService platformCategoryService) {
        this.platformCategoryService = platformCategoryService;
    }

    @GetMapping("/platform")
    public ResponseEntity<?> getRootPlatformCategories() {
        return ResponseEntity.ok(platformCategoryService.getRootPlatformCategories());
    }

    @GetMapping("/platform/sub-categories")
    public ResponseEntity<?> getPlatformSubCategories(@RequestParam("platform-category-id") Long platformCategoryId) {
        return ResponseEntity.ok(platformCategoryService.getImmediateSubCategories(platformCategoryId));
    }

    @GetMapping("/platform/{platform-category-id}")
    public ResponseEntity<?> getPlatformCategory(@PathVariable("platform-category-id") Long platformCategoryId) {
        return ResponseEntity.ok(platformCategoryService.getPlatformCategory(platformCategoryId));
    }
}
