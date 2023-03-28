package restaurant.service.strategy;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;

import java.util.List;

public class AllStrategy implements RecommendationStrategy {
    @Override
    public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, Cuisine primaryCuisine, Cost primaryCostBracket) {
        return restaurants;
    }
}
