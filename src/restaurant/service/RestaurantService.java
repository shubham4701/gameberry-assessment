package restaurant.service;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {
    private final Map<String, Restaurant> restaurants;

    public RestaurantService() {
        this.restaurants = new HashMap<>();
    }

    public String onboardRestaurant(Cuisine cuisine, Cost costBracket, float rating, boolean isRecommended) {
        Restaurant restaurant = new Restaurant(cuisine, costBracket, rating, isRecommended);
        restaurants.put(restaurant.getId(), restaurant);
        return restaurant.getId();
    }

    public Restaurant getRestaurant(String id) {
        return this.restaurants.get(id);
    }

    public List<Restaurant> getAvailableRestaurants() {
        return new ArrayList<>(restaurants.values());
    }
}
