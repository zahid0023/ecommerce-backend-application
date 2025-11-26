package org.example.ecommercebackendapplication.controller.shopowner;

import org.example.ecommercebackendapplication.dto.request.shop.ShopCreateRequest;
import org.example.ecommercebackendapplication.model.entity.ShopOwnerEntity;
import org.example.ecommercebackendapplication.service.ShopService;
import org.example.ecommercebackendapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchants")
public class ShopController {
    private final ShopService shopService;
    private final UserService userService;

    public ShopController(ShopService shopService, UserService userService) {
        this.shopService = shopService;
        this.userService = userService;
    }

    @PostMapping("/shops")
    public ResponseEntity<?> createShop(@RequestBody ShopCreateRequest shopCreateRequest) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        ShopOwnerEntity shopOwnerEntity = new ShopOwnerEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.createShop(shopCreateRequest, shopOwnerEntity));
    }

    @GetMapping("/shops")
    public ResponseEntity<?> getAllShops() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        ShopOwnerEntity shopOwnerEntity = new ShopOwnerEntity();
        return ResponseEntity.ok(shopService.getAllShops(shopOwnerEntity));
    }

    @GetMapping("/shops/{shop-id}")
    public ResponseEntity<?> getShopById(@PathVariable("shop-id") Long id) {
        return ResponseEntity.ok(shopService.getShopById(id));
    }
}
