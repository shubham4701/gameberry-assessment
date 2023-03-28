package restaurant.service.strategy;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class FeaturedStrategy implements RecommendationStrategy {

    @Override
    public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, Cuisine primaryCuisine, Cost primaryCostBracket) {
        List<Restaurant> recommendations = restaurants.stream().filter(restaurant -> restaurant.isRecommended() &&
                restaurant.getCuisine().equals(primaryCuisine) &&
                restaurant.getCostBracket().equals(primaryCostBracket)).collect(Collectors.toList());
        if (recommendations.isEmpty()) {
            recommendations = restaurants.stream().filter(restaurant -> restaurant.isRecommended() &&
                    restaurant.getCuisine().equals(primaryCuisine) ||
                    restaurant.getCostBracket().equals(primaryCostBracket)).collect(Collectors.toList());
        }
        return recommendations;
    }
}
