package org.example.ecommercebackendapplication.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/categories")
public class CategoryControllerForAdmin {

    @PostMapping
    public ResponseEntity<?> addCategory() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Category created successfully");
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<?> getCategory(@PathVariable("category-id") Long categoryId) {
        return ResponseEntity.ok("Category fetched successfully");
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<?> updateCategory(@PathVariable("category-id") Long categoryId) {
        return ResponseEntity.ok("Category updated successfully");
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("category-id") Long categoryId) {
        return ResponseEntity.ok("Category deleted successfully");
    }
}
