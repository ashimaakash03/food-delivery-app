package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.exception.*;
import com.niit.bej.restaurant.service.model.Menu;
import com.niit.bej.restaurant.service.model.Restaurant;
import com.niit.bej.restaurant.service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurant.getRestaurantId());
        if (optionalRestaurant.isPresent()) {
            throw new RestaurantAlreadyExistException("Restaurant already present in the city");
        } else {
            return this.restaurantRepository.save(restaurant);
        }
    }

    @Override
    public List<Restaurant> findAllRestaurantsByName(String restaurantName) throws EmptyDatabaseException {
        List<Restaurant> restaurantsByName = this.restaurantRepository.findRestaurantByName(restaurantName);
        if (restaurantsByName.isEmpty()) {
            throw new EmptyDatabaseException("No Restaurants found by name: " + restaurantName);
        } else {
            return restaurantsByName;
        }
    }

    @Override
    public List<Restaurant> findAllRestaurants() throws EmptyDatabaseException {
        List<Restaurant> restaurantList = this.restaurantRepository.findAll();
        if (restaurantList.isEmpty()) {
            throw new EmptyDatabaseException("No Restaurants found ");
        } else {
            return restaurantList;
        }
    }

    @Override
    public List<Restaurant> findAllRestaurantsByCity(String city) throws EmptyDatabaseException {
        List<Restaurant> restaurantsInCity = this.restaurantRepository.findByCity(city);
        if (restaurantsInCity.isEmpty()) {
            throw new EmptyDatabaseException("No Restaurants found in city: " + city);
        } else {
            return restaurantsInCity;
        }
    }

    @Override
    public Restaurant updateRestaurantById(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurant.getRestaurantId());
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurantToBeUpdated = optionalRestaurant.get();

            restaurantToBeUpdated.setRestaurantName(restaurant.getRestaurantName());
            restaurantToBeUpdated.setCity(restaurant.getCity());

            return this.restaurantRepository.save(restaurantToBeUpdated);
        } else {
            throw new RestaurantNotFoundException("Restaurant with ID: " + restaurant.getRestaurantId() + " not found");
        }
    }

    @Override
    public boolean deleteRestaurantById(int restaurantId) throws RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            this.restaurantRepository.deleteById(restaurantId);
            return true;
        } else {
            throw new RestaurantNotFoundException("Restaurant with ID: " + restaurantId + " not found");
        }
    }

    @Override
    public Menu addMenuItem(int restaurantId, Menu menu) throws ItemAlreadyPresentException, RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            if (menuListOfRestaurant.contains(menu)) {
                throw new ItemAlreadyPresentException("Menu Item already present");
            } else {
                menuListOfRestaurant.add(menu);
                return menu;
            }
        } else {
            throw new RestaurantNotFoundException("Searched restaurant not found");
        }
    }
    @Override
    public List<Menu> findAllItemsUnderCategory(int restaurantId, String category) throws RestaurantNotFoundException, EmptyDatabaseException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            if (menuListOfRestaurant.isEmpty()) {
                throw new EmptyDatabaseException("No Items present in the menu");
            }
            List<Menu> itemsUnderCategory = new ArrayList<>();
            for (Menu menu : menuListOfRestaurant) {
                String category1 = menu.getCategory();
                if (category1.equals(category)) {
                    itemsUnderCategory.add(menu);
                }
            }
            return itemsUnderCategory;
        } else {
            throw new RestaurantNotFoundException("Searched restaurant not found");
        }
    }

    @Override
    public Menu findItemByName(int restaurantId, String itemName) throws EmptyDatabaseException, ItemNotFoundException, RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            if (menuListOfRestaurant.isEmpty()) {
                throw new EmptyDatabaseException("No Items present in the menu");
            } else {
                Menu searchedItem = null;
                for (Menu menu : menuListOfRestaurant) {
                    if (menu.getItemName().equals(itemName)) {
                        searchedItem = menu;
                    } else {
                        throw new ItemNotFoundException("Item with name: " + itemName + " not found");
                    }
                }
                return searchedItem;
            }
        } else {
            throw new RestaurantNotFoundException("Searched restaurant with ID: " + restaurantId + "not found");
        }
    }

    @Override
    public List<Menu> findAllMenuItems(int restaurantId) throws EmptyDatabaseException, RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            if (menuListOfRestaurant.isEmpty()) {
                throw new EmptyDatabaseException("No Items present in the menu");
            } else {
                return menuListOfRestaurant;
            }
        } else {
            throw new RestaurantNotFoundException("Searched restaurant with ID: " + restaurantId + "not found");
        }
    }

    @Override
    public Menu updateMenuItemDetails(int restaurantId, Menu menu) throws EmptyDatabaseException, RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            if (menuListOfRestaurant.isEmpty()) {
                throw new EmptyDatabaseException("No Items present in the menu");
            }
            Menu updatedMenu = null;
            if (menuListOfRestaurant.contains(menu)) {
                Menu menuItemToBeUpdated = new Menu();
                menuItemToBeUpdated.setItemName(menu.getItemName());
                menuItemToBeUpdated.setCategory(menu.getCategory());
                menuItemToBeUpdated.setPrice(menu.getPrice());

                updatedMenu = menuItemToBeUpdated;
            }
            return updatedMenu;
        } else {
            throw new RestaurantNotFoundException("Searched restaurant with ID: " + restaurantId + "not found");
        }
    }

    @Override
    public boolean deleteMenuItemById(int restaurantId, long id) throws ItemNotFoundException, RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            boolean result = false;
            for (Menu menu : menuListOfRestaurant) {
                if (menu.getId() == id) {
                    menuListOfRestaurant.remove(menu);
                    result = true;
                } else {
                    throw new ItemNotFoundException("Item with ID: " + id + " not found");
                }
            }
            return result;
        } else {
            throw new RestaurantNotFoundException("Searched restaurant with ID: " + restaurantId + "not found");
        }
    }

    @Override
    public boolean deleteMenuItemByName(int restaurantId, String itemName) throws RestaurantNotFoundException, ItemNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant requiredRestaurant = optionalRestaurant.get();
            List<Menu> menuListOfRestaurant = requiredRestaurant.getMenuList();
            boolean result = false;
            for (Menu menu : menuListOfRestaurant) {
                if (menu.getItemName().equals(itemName)) {
                    menuListOfRestaurant.remove(menu);
                    result = true;
                } else {
                    throw new ItemNotFoundException("Item with name: " + itemName + " not found");
                }
            }
            return result;
        } else {
            throw new RestaurantNotFoundException("Searched restaurant with ID: " + restaurantId + "not found");
        }
    }
}
