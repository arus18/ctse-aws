package com.orderprocessing.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/items")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem addedMenuItem = menuService.addMenuItem(menuItem);
        return new ResponseEntity<>(addedMenuItem, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuService.getAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        MenuItem menuItem = menuService.getMenuItemById(id);
        if (menuItem != null) {
            return new ResponseEntity<>(menuItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
        MenuItem updatedMenuItem = menuService.updateMenuItem(id, menuItem);
        if (updatedMenuItem != null) {
            return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
        return ResponseEntity.ok("Item with ID " + id + " deleted successfully.");
    }
}

