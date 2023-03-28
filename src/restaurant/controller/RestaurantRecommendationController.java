package restaurant.controller;

import restaurant.model.Restaurant;
import restaurant.service.RestaurantRecommendationService;

import java.util.List;

public class RestaurantRecommendationController {

    private final RestaurantRecommendationService restaurantRecommendationService;

    public RestaurantRecommendationController(RestaurantRecommendationService restaurantRecommendationService) {
        this.restaurantRecommendationService = restaurantRecommendationService;
    }

    public List<Restaurant> getRecommendations(String userId) {
        return this.restaurantRecommendationService.getRecommendations(userId);
    }

    public void setRecommendationSize(int size) {
        this.restaurantRecommendationService.setRecommendationSize(size);
    }

    public void clearRecommendationStrategies() {
        this.restaurantRecommendationService.clearRecommendationStrategies();
    }
}
