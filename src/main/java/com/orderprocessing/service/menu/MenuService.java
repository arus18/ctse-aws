package com.orderprocessing.service.menu;

import java.util.List;

public interface MenuService {
    MenuItem addMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
    MenuItem getMenuItemById(Long id);
    List<MenuItem> getAllMenuItems();
    void deleteMenuItem(Long id);
}

