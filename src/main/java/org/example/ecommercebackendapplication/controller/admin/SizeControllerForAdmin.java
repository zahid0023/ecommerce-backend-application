package org.example.ecommercebackendapplication.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/sizes")
public class SizeControllerForAdmin {

    @PostMapping
    public ResponseEntity<?> addSize() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Size created successfully");
    }

    @GetMapping("/{size-id}")
    public ResponseEntity<?> getSize(@PathVariable("size-id") Long sizeId) {
        return ResponseEntity.ok("Size fetched successfully");
    }

    @PutMapping("/{size-id}")
    public ResponseEntity<?> updateSize(@PathVariable("size-id") Long sizeId) {
        return ResponseEntity.ok("Size updated successfully");
    }

    @DeleteMapping("/{size-id}")
    public ResponseEntity<?> deleteSize(@PathVariable("size-id") Long sizeId) {
        return ResponseEntity.ok("Size deleted successfully");
    }
}
