package restaurant.service.strategy;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LatestStrategy implements RecommendationStrategy {
    private static final int count = 4;
    @Override
    public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, Cuisine primaryCuisine, Cost primaryCostBracket) {
        return restaurants.stream().sorted(Comparator.comparing(Restaurant::getOnboardedTime)).collect(Collectors.toList()).subList(0, count);
    }
}
