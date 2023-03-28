package restaurant.service.strategy;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;

import java.util.List;

public interface RecommendationStrategy {
    List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, Cuisine primaryCuisine, Cost primaryCostBracket);

}
