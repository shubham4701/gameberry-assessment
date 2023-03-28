package restaurant.service;

import restaurant.model.Restaurant;

public class OrderService {
    private final RestaurantService restaurantService;
    private final UserPreferenceService userPreferenceService;

    public OrderService(RestaurantService restaurantService, UserPreferenceService userPreferenceService) {
        this.restaurantService = restaurantService;
        this.userPreferenceService = userPreferenceService;
    }

    public void order(String userId, String restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        userPreferenceService.updateUserPreferences(userId, restaurant.getCuisine(), restaurant.getCostBracket());
    }
}
