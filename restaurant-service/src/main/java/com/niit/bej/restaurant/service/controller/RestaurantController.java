package com.niit.bej.restaurant.service.controller;

import com.niit.bej.restaurant.service.exception.*;
import com.niit.bej.restaurant.service.model.Menu;
import com.niit.bej.restaurant.service.model.Restaurant;
import com.niit.bej.restaurant.service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) {
        try {
            Restaurant addedRestaurant = this.restaurantService.addRestaurant(restaurant);
            return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
        } catch (RestaurantAlreadyExistException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/fetch/{restaurantName}")
    public ResponseEntity<?> fetchAllRestaurantsByName(@PathVariable String restaurantName) {
        try {
            List<Restaurant> restaurantsByName = this.restaurantService.findAllRestaurantsByName(restaurantName);
            return new ResponseEntity<>(restaurantsByName, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/fetch/all")
    public ResponseEntity<?> fetchAllRestaurants() {
        try {
            List<Restaurant> allRestaurantsList = this.restaurantService.findAllRestaurants();
            return new ResponseEntity<>(allRestaurantsList, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/fetch/{city}")
    public ResponseEntity<?> fetchAllRestaurantsByCity(@PathVariable String city) {
        try {
            List<Restaurant> restaurantsInCity = this.restaurantService.findAllRestaurantsByCity(city);
            return new ResponseEntity<>(restaurantsInCity, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<?> updateRestaurantById(@RequestBody Restaurant restaurant, @PathVariable int restaurantId) {
        try {
            Restaurant updatedRestaurant = this.restaurantService.updateRestaurantById(restaurant);
            return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
        } catch (RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable int restaurantId) {
        try {
            this.restaurantService.deleteRestaurantById(restaurantId);
            return new ResponseEntity<>("Restaurant with ID: " + restaurantId + " deleted", HttpStatus.OK);
        } catch (RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/menu/add/{restaurantId}")
    public ResponseEntity<?> addItemInMenu(@RequestBody Menu menu, @PathVariable int restaurantId) {
        try {
            Menu newlyAddedItem = this.restaurantService.addMenuItem(restaurantId, menu);
            return new ResponseEntity<>(newlyAddedItem, HttpStatus.CREATED);
        } catch (ItemAlreadyPresentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        } catch (RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/menu/fetch/{restaurantId}/{category}")
    public ResponseEntity<?> findAllItemsUnderCategory(@PathVariable int restaurantId, @PathVariable String category) {
        try {
            List<Menu> allItemsUnderCategory = this.restaurantService.findAllItemsUnderCategory(restaurantId, category);
            return new ResponseEntity<>(allItemsUnderCategory, HttpStatus.FOUND);
        } catch (RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/menu/fetch/{restaurantId}/{itemName}")
    public ResponseEntity<?> findItemByName(@PathVariable int restaurantId, @PathVariable String itemName) {
        try {
            Menu searchedItem = this.restaurantService.findItemByName(restaurantId, itemName);
            return new ResponseEntity<>(searchedItem, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (RestaurantNotFoundException | ItemNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/menu/fetch/{restaurantId}")
    public ResponseEntity<?> findAllItemsInMenu(@PathVariable int restaurantId) {
        try {
            List<Menu> allItemsInMenu = this.restaurantService.findAllMenuItems(restaurantId);
            return new ResponseEntity<>(allItemsInMenu, HttpStatus.OK);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/menu/update/{restaurantId}")
    public ResponseEntity<?> updateMenuItem(@RequestBody Menu menu, @PathVariable int restaurantId) {
        try {
            Menu updatedMenuItem = this.restaurantService.updateMenuItemDetails(restaurantId, menu);
            return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/menu/delete/{restaurantId}/{id}")
    public ResponseEntity<?> deleteItemFromMenuById(@PathVariable int restaurantId, @PathVariable long id) {
        try {
            this.restaurantService.deleteMenuItemById(restaurantId, id);
            return new ResponseEntity<>("Item with ID: " + id + " deleted from menu", HttpStatus.OK);
        } catch (RestaurantNotFoundException | ItemNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/menu/delete/{restaurantId}/{itemName}")
    public ResponseEntity<?> deleteItemFromMenuByName(@PathVariable int restaurantId, @PathVariable String itemName) {
        try {
            this.restaurantService.deleteMenuItemByName(restaurantId, itemName);
            return new ResponseEntity<>("Item having name " + itemName + " deleted from menu", HttpStatus.OK);
        } catch (RestaurantNotFoundException | ItemNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
