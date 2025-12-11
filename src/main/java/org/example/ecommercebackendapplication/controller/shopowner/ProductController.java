package org.example.ecommercebackendapplication.controller.shopowner;

import org.example.ecommercebackendapplication.dto.request.product.CreateProductRequest;
import org.example.ecommercebackendapplication.model.entity.ShopEntity;
import org.example.ecommercebackendapplication.service.ProductService;
import org.example.ecommercebackendapplication.service.ShopService;
import org.example.ecommercebackendapplication.service.UserService;
import org.example.ecommercebackendapplication.utils.AuthContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/merchants/products")
public class ProductController {
    private final ShopService shopService;
    private final UserService userService;
    private final ProductService productService;

    public ProductController(ShopService shopService,
                             UserService userService,
                             ProductService productService) {
        this.shopService = shopService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest request) {
        boolean isShopOwnedByMerchant = shopService.isShopOwnedByMerchant(AuthContext.getUserId(), request.getShopId());
        ShopEntity shopEntity = shopService.getShopEntityById(request.getShopId());
        return ResponseEntity.status(201).body(productService.createProduct(null, null, null));
    }
}
