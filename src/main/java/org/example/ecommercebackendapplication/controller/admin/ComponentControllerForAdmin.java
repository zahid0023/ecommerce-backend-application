package org.example.ecommercebackendapplication.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/components")
public class ComponentControllerForAdmin {

    @PostMapping("/types")
    public ResponseEntity<?> addComponentType() {
        // TODO: call service to add component type
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Component type created successfully");
    }

    @GetMapping("/types/{component-type-id}")
    public ResponseEntity<?> getComponentType(@PathVariable("component-type-id") Long componentId) {
        // TODO: call service to fetch component type
        return ResponseEntity.ok("Component type fetched successfully");
    }

    @PutMapping("/types/{component-type-id}")
    public ResponseEntity<?> updateComponentType(@PathVariable("component-type-id") Long componentId) {
        // TODO: call service to update component type
        return ResponseEntity.ok("Component type updated successfully");
    }

    @DeleteMapping("/types/{component-type-id}")
    public ResponseEntity<?> deleteComponentType(@PathVariable("component-type-id") Long componentId) {
        // TODO: call service to delete component type
        return ResponseEntity.ok("Component type deleted successfully");
    }
}
