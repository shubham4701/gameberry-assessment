import restaurant.config.BeanConfig;
import restaurant.controller.RestaurantController;
import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.Restaurant;
import restaurant.model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.getRestaurantRecommendationController().setRecommendationSize(5);
        onboardRestaurants(beanConfig.getRestaurantController());
        String userId = beanConfig.getUserController().addUser();
        User user = beanConfig.getUserController().getUser(userId);
        System.out.println("--------- Ordering and Changing User Preferences -------------");
        for (Restaurant restaurant : beanConfig.getRestaurantController().getAvailableRestaurants()) {
            beanConfig.getOrderController().order(userId, restaurant.getId());
            System.out.print("Preferred Cost : " + beanConfig.getUserPreferenceService().getCostPreference(user) + ", ");
            System.out.println("Preferred Cuisine : " + beanConfig.getUserPreferenceService().getCuisinePreference(user));
        }
        System.out.println("\n\n---------- Restaurant Recommendations ------------");
        List<Restaurant> restaurants = beanConfig.getRestaurantRecommendationController().getRecommendations(userId);
        for (Restaurant restaurant : restaurants) {
            System.out.println("Recommendation : " + restaurant.toString());
        }
    }

    private static void onboardRestaurants(RestaurantController restaurantController) throws InterruptedException {
        restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, Cost.ONE, 5, true);
        restaurantController.addRestaurant(Cuisine.SOUTH_INDIAN, Cost.TWO, 5, false);
        restaurantController.addRestaurant(Cuisine.SEAFOOD, Cost.THREE, 3, false);
        restaurantController.addRestaurant(Cuisine.CHINESE, Cost.FOUR, 5, true);
        restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, Cost.FIVE, 5, true);
        restaurantController.addRestaurant(Cuisine.ITALIAN, Cost.ONE, 3, false);
        restaurantController.addRestaurant(Cuisine.CHINESE, Cost.TWO, 5, true);
        restaurantController.addRestaurant(Cuisine.SOUTH_INDIAN, Cost.THREE, 5, true);
        restaurantController.addRestaurant(Cuisine.NORTH_INDIAN, Cost.FOUR, 3, false);
        restaurantController.addRestaurant(Cuisine.CHINESE, Cost.FIVE, 5, true);
        restaurantController.addRestaurant(Cuisine.SOUTH_INDIAN, Cost.ONE, 5, true);
        restaurantController.addRestaurant(Cuisine.CHINESE, Cost.TWO, 3, false);
    }

}
