package org.example.ecommercebackendapplication.controller.designer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/designer/components")
public class ComponentControllerForDesigner {
    @PostMapping
    public ResponseEntity<?> createComponent() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{component-id}")
    public ResponseEntity<?> getComponent(@PathVariable("component-id") Long componentId) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{component-id}")
    public ResponseEntity<?> updateComponent(@PathVariable("component-id") Long componentId) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{component-id}")
    public ResponseEntity<?> deleteComponent(@PathVariable("component-id") Long componentId) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
