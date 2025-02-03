package org.grocery.service;

import org.grocery.dao.GroceryItemRepository;
import org.grocery.entity.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
    public List<GroceryItem> getGroceriesByIds(List<Long> ids) {
        return groceryItemRepository.findAllById(ids);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem itemDetails) {
        GroceryItem item = groceryItemRepository.findById(id).orElseThrow();
        item.setName(itemDetails.getName());
        item.setPrice(itemDetails.getPrice());
        item.setStock(itemDetails.getStock());
        return groceryItemRepository.save(item);
    }
}

