package com.orderprocessing.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    // Autowiring MenuService for dependency injection
    @Autowired
    private MenuService menuService;

    // Endpoint for adding a new menu item via POST request
    @PostMapping("/items")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
         // Invoking the addMenuItem method of MenuService to add the new menu item
        MenuItem addedMenuItem = menuService.addMenuItem(menuItem);
        // Returning a ResponseEntity with the added menu item and HTTP status code 201 (CREATED)
        return new ResponseEntity<>(addedMenuItem, HttpStatus.CREATED);
    }

    // Endpoint for retrieving all menu items via GET request
    @GetMapping("/items")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        // Invoking the getAllMenuItems method of MenuService to retrieve all menu items
        List<MenuItem> menuItems = menuService.getAllMenuItems();
        // Returning a ResponseEntity with the list of menu items and HTTP status code 200 (OK)
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    // Endpoint for retrieving a menu item by its ID via GET request
    @GetMapping("/items/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        // Invoking the getMenuItemById method of MenuService to retrieve the menu item by ID
        MenuItem menuItem = menuService.getMenuItemById(id);
        // Checking if the menu item is found
        if (menuItem != null) {
            // Returning a ResponseEntity with the menu item and HTTP status code 200 (OK)
            return new ResponseEntity<>(menuItem, HttpStatus.OK);
        } else {
            // Returning a ResponseEntity with HTTP status code 404 (NOT FOUND) if the menu item is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for updating a menu item by its ID via PUT request
    @PutMapping("/items/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
        // Invoking the updateMenuItem method of MenuService to update the menu item by ID
        MenuItem updatedMenuItem = menuService.updateMenuItem(id, menuItem);
        // Checking if the menu item is updated successfully
        if (updatedMenuItem != null) {
            // Returning a ResponseEntity with the updated menu item and HTTP status code 200 (OK)
            return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
        } else {
            // Returning a ResponseEntity with HTTP status code 404 (NOT FOUND) if the menu item is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for deleting a menu item by its ID via DELETE request
    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        // Invoking the deleteMenuItem method of MenuService to delete the menu item by ID
        menuService.deleteMenuItem(id);
        // Returning a ResponseEntity with a success message and HTTP status code 200 (OK)
        return ResponseEntity.ok("Item with ID " + id + " deleted successfully.");
    }
}

