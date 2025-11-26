package org.example.ecommercebackendapplication.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/colors")
public class ColorControllerForAdmin {

    @PostMapping
    public ResponseEntity<?> addColor() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Color created successfully");
    }

    @GetMapping("/{colorId}")
    public ResponseEntity<?> getColor(@PathVariable Long colorId) {
        return ResponseEntity.ok("Color fetched successfully");
    }

    @PutMapping("/{colorId}")
    public ResponseEntity<?> updateColor(@PathVariable Long colorId) {
        return ResponseEntity.ok("Color updated successfully");
    }

    @DeleteMapping("/{colorId}")
    public ResponseEntity<?> deleteColor(@PathVariable Long colorId) {
        return ResponseEntity.ok("Color deleted successfully");
    }
}
