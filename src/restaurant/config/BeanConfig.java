package restaurant.config;

import restaurant.controller.OrderController;
import restaurant.controller.RestaurantController;
import restaurant.controller.RestaurantRecommendationController;
import restaurant.controller.UserController;
import restaurant.service.*;
import restaurant.service.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class BeanConfig {
    private final OrderController orderController;
    private final OrderService orderService;
    private final RestaurantController restaurantController;
    private final RestaurantService restaurantService;
    private final RestaurantRecommendationController restaurantRecommendationController;
    private final RestaurantRecommendationService restaurantRecommendationService;
    private final UserController userController;
    private final UserService userService;
    private final UserPreferenceService userPreferenceService;

    public BeanConfig() {
        this.userService = getUserServiceBean();
        this.restaurantService = getRestaurantServiceBean();
        this.userPreferenceService = getUserPreferenceServiceBean(userService);
        this.orderService = getOrderServiceBean(restaurantService, userPreferenceService);
        this.restaurantRecommendationService = getRestaurantRecommendationServiceBean(restaurantService, userPreferenceService, userService);
        this.orderController = getOrderControllerBean(orderService);
        this.restaurantController = getRestaurantControllerBean(restaurantService);
        this.restaurantRecommendationController = getRestaurantRecommendationControllerBean(restaurantRecommendationService);
        this.userController = getUserControllerBean(userService);
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public RestaurantController getRestaurantController() {
        return restaurantController;
    }

    public RestaurantService getRestaurantService() {
        return restaurantService;
    }

    public RestaurantRecommendationController getRestaurantRecommendationController() {
        return restaurantRecommendationController;
    }

    public RestaurantRecommendationService getRestaurantRecommendationService() {
        return restaurantRecommendationService;
    }

    public UserController getUserController() {
        return userController;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserPreferenceService getUserPreferenceService() {
        return userPreferenceService;
    }

    private OrderController getOrderControllerBean(OrderService orderService) {
        return new OrderController(orderService);
    }

    private RestaurantController getRestaurantControllerBean(RestaurantService restaurantService) {
        return new RestaurantController(restaurantService);
    }

    private UserController getUserControllerBean(UserService userService) {
        return new UserController(userService);
    }

    private RestaurantRecommendationController getRestaurantRecommendationControllerBean(RestaurantRecommendationService restaurantRecommendationService) {
        return new RestaurantRecommendationController(restaurantRecommendationService);
    }

    private RestaurantRecommendationService getRestaurantRecommendationServiceBean(RestaurantService restaurantService, UserPreferenceService userPreferenceService, UserService userService) {
        return new RestaurantRecommendationService(formulateRecommendationStrategy(), restaurantService, userPreferenceService, userService);
    }

    private UserService getUserServiceBean() {
        return new UserService();
    }

    private RestaurantService getRestaurantServiceBean() {
        return new RestaurantService();
    }

    private UserPreferenceService getUserPreferenceServiceBean(UserService userService) {
        return new UserPreferenceService(userService);
    }

    private OrderService getOrderServiceBean(RestaurantService restaurantService, UserPreferenceService userPreferenceService) {
        return new OrderService(restaurantService, userPreferenceService);
    }

    private List<RecommendationStrategy> formulateRecommendationStrategy() {
        List<RecommendationStrategy> restaurantRecommendationStrategyList = new ArrayList<>();
        restaurantRecommendationStrategyList.add(new FeaturedStrategy());
        restaurantRecommendationStrategyList.add(new FilterByCuisineAndCostWithRatingGreaterThanStrategy());
        restaurantRecommendationStrategyList.add(new FIlterByCuisineAndRatingGreaterThanStrategy());
        restaurantRecommendationStrategyList.add(new FilterByCostAndRatingGreaterThanStrategy());
        restaurantRecommendationStrategyList.add(new LatestStrategy());
        restaurantRecommendationStrategyList.add(new FilterByCuisineAndCostWithRatingLessThanStrategy());
        restaurantRecommendationStrategyList.add(new FIlterByCuisineAndRatingLessThanStrategy());
        restaurantRecommendationStrategyList.add(new FilterByCostAndRatingLessThanStrategy());
        restaurantRecommendationStrategyList.add(new AllStrategy());
        return restaurantRecommendationStrategyList;
    }
}
