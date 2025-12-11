package org.example.ecommercebackendapplication.controller.shopowner;

import org.example.ecommercebackendapplication.dto.request.category.shop.ShopCategoryCreateRequest;
import org.example.ecommercebackendapplication.model.entity.PlatformCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopCategoryEntity;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.service.PlatformCategoryService;
import org.example.ecommercebackendapplication.service.ShopCategoryService;
import org.example.ecommercebackendapplication.service.ShopService;
import org.example.ecommercebackendapplication.utils.AuthContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchants/categories")
public class ShopCategoryController {
    private final PlatformCategoryService platformCategoryService;
    private final ShopService shopService;
    private final ShopCategoryService shopCategoryService;

    public ShopCategoryController(PlatformCategoryService platformCategoryService,
                                  ShopService shopService,
                                  ShopCategoryService shopCategoryService) {
        this.platformCategoryService = platformCategoryService;
        this.shopService = shopService;
        this.shopCategoryService = shopCategoryService;
    }

    @GetMapping("/platform/root")
    public ResponseEntity<?> getRootPlatformCategories() {
        return ResponseEntity.ok(platformCategoryService.getRootPlatformCategories());
    }

    @GetMapping("/platform/{platform-category-id}/sub-categories")
    public ResponseEntity<?> getPlatformSubCategories(@PathVariable("platform-category-id") Long platformCategoryId) {
        return ResponseEntity.ok(platformCategoryService.getImmediateSubCategories(platformCategoryId));
    }

    @GetMapping("/platform/{platform-category-id}/nested")
    public ResponseEntity<?> getPlatformCategoryNested(@PathVariable("platform-category-id") Long platformCategoryId) {
        return ResponseEntity.ok(platformCategoryService.getPlatformCategoryNested(platformCategoryId));
    }

    @PostMapping
    public ResponseEntity<?> createShopCategory(@RequestBody ShopCategoryCreateRequest request) {
        boolean isShopOwnedByMerchant = shopService.isShopOwnedByMerchant(AuthContext.getUserId(), request.getShopId());

        if (!isShopOwnedByMerchant) {
            return ResponseEntity.status(403).body("Shop does not belong to merchant");
        }

        ShopEntity shopEntity = shopService.getShopEntityById(request.getShopId());
        ShopCategoryEntity parentShopCategoryEntity = request.getParentId() != null && request.getParentId() > 0 ? shopCategoryService.getShopCategoryEntity(request.getParentId()) : null;
        PlatformCategoryEntity platformCategoryEntity = platformCategoryService.getPlatformCategoryEntity(request.getPlatformCategoryId());
        return ResponseEntity.status(201).body(shopCategoryService.createShopCategory(request, shopEntity, parentShopCategoryEntity, platformCategoryEntity));
    }
}
