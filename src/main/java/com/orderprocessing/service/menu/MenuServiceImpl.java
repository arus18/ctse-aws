package com.orderprocessing.service.menu;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuItemRepository menuItemRepository;

    public MenuServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        Optional<MenuItem> existingMenuItemOptional = menuItemRepository.findById(id);
        if (existingMenuItemOptional.isPresent()) {
            MenuItem existingMenuItem = existingMenuItemOptional.get();
            existingMenuItem.setName(menuItem.getName());
            existingMenuItem.setDescription(menuItem.getDescription());
            existingMenuItem.setPrice(menuItem.getPrice());
            return menuItemRepository.save(existingMenuItem);
        } else {
            return null; // or throw exception
        }
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}

