package org.grocery.controller;

import org.grocery.entity.UserInfo;
import org.grocery.service.GroceryItemService;
import org.grocery.entity.GroceryItem;
import org.grocery.service.UserInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GroceryItemController {
    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    UserInfoDetailService userInfoDetailService;

    /*Add new grocery items to the system*/
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/grocery/add")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return groceryItemService.addGroceryItem(item);
    }

   /* View existing grocery items*/
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/grocery/get")
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }


    /*Ability to book multiple grocery items in a single order*/
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/grocery/getById")
    public List<GroceryItem> getGroceriesByIds(@RequestParam List<Long> ids) {
        List<GroceryItem> groceries = groceryItemService.getGroceriesByIds(ids);
        return groceries;
    }

    /*Remove grocery items from the system*/
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @DeleteMapping("/grocery/delete/{id}")
    public void deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
    }

    /*Update details (e.g., name, price) of existing grocery items*/
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PutMapping("/grocery/update/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return groceryItemService.updateGroceryItem(id, item);
    }

    @PostMapping("/newUser")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return userInfoDetailService.addUser(userInfo);
    }
}
