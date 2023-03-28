package restaurant.controller;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;
import restaurant.service.RestaurantService;

import java.util.List;

public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public void addRestaurant(Cuisine cuisine, Cost costBracket, float rating, boolean isRecommended) {
        this.restaurantService.onboardRestaurant(cuisine, costBracket, rating, isRecommended);
    }

    public List<Restaurant> getAvailableRestaurants() {
        return this.restaurantService.getAvailableRestaurants();
    }
}
