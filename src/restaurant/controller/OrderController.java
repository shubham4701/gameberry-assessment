package restaurant.controller;

import restaurant.service.OrderService;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void order(String userId, String restaurantId) {
        this.orderService.order(userId, restaurantId);
    }
}
