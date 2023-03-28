package restaurant.service.strategy;



import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByCuisineAndCostWithRatingLessThanStrategy implements RecommendationStrategy {
    private static final float rating = 4F;

    @Override
    public List<Restaurant> recommendRestaurants(List<Restaurant> restaurants, Cuisine primaryCuisine, Cost primaryCostBracket) {
        return restaurants.stream().filter(restaurant -> restaurant.getCuisine().equals(primaryCuisine) &&
                restaurant.getCostBracket().equals(primaryCostBracket) && restaurant.getRating() < rating).collect(Collectors.toList());
    }
}
