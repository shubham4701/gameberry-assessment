package restaurant.service;



import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;
import restaurant.model.User;
import restaurant.service.strategy.RecommendationStrategy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RestaurantRecommendationService {
    private final List<RecommendationStrategy> recommendationStrategies;
    private final RestaurantService restaurantService;
    private final UserPreferenceService userPreferenceService;
    private final UserService userService;
    private int recommendationSize;

    public RestaurantRecommendationService(List<RecommendationStrategy> recommendationStrategies, RestaurantService restaurantService, UserPreferenceService userPreferenceService, UserService userService) {
        this.recommendationStrategies = recommendationStrategies;
        this.userPreferenceService = userPreferenceService;
        recommendationSize = 0;
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    public void addRecommendationStrategies(List<RecommendationStrategy> recommendationStrategies) {
        this.recommendationStrategies.addAll(recommendationStrategies);
    }

    public void setRecommendationSize(int recommendationSize) {
        this.recommendationSize = recommendationSize;
    }

    public List<Restaurant> getRecommendations(String userId) {
        User user = userService.getUser(userId);
        List<Restaurant> restaurants = restaurantService.getAvailableRestaurants();
        Cuisine primaryCuisine = userPreferenceService.getCuisinePreference(user);
        Cost primaryCostBracket = userPreferenceService.getCostPreference(user);
        Set<Restaurant> recommendations = new LinkedHashSet<>();
        for (RecommendationStrategy recommendationStrategy : recommendationStrategies) {
            if (recommendations.size() > recommendationSize) {
                break;
            }
            List<Restaurant> recommendedRestaurants = recommendationStrategy.recommendRestaurants(restaurants, primaryCuisine, primaryCostBracket);
            recommendations.addAll(recommendedRestaurants);
        }
        return new ArrayList<>(recommendations).subList(0, recommendationSize - 1);
    }

    public void clearRecommendationStrategies() {
        this.recommendationStrategies.clear();
    }
}
