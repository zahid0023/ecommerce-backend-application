package org.example.ecommercebackendapplication.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/pages")
public class PageControllerForAdmin {

    @PostMapping("/types")
    public ResponseEntity<?> addPageType() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Page type created successfully");
    }

    @GetMapping("/types/{page-type-id}")
    public ResponseEntity<?> getPageType(@PathVariable("page-type-id") Long pageTypeId) {
        return ResponseEntity.ok("Page type fetched successfully");
    }

    @PutMapping("/types/{page-type-id}")
    public ResponseEntity<?> updatePageType(@PathVariable("page-type-id") Long pageTypeId) {
        return ResponseEntity.ok("Page type updated successfully");
    }

    @DeleteMapping("/types/{page-type-id}")
    public ResponseEntity<?> deletePageType(@PathVariable("page-type-id") Long pageTypeId) {
        return ResponseEntity.ok("Page type deleted successfully");
    }
}
