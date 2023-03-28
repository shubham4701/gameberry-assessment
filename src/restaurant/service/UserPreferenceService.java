package restaurant.service;

import restaurant.model.Cost;
import restaurant.model.Cuisine;
import restaurant.model.User;

import java.util.Map;

public class UserPreferenceService {

    private final UserService userService;

    public UserPreferenceService(UserService userService) {
        this.userService = userService;
    }

    public void updateUserPreferences(String userId, Cuisine cuisine, Cost cost) {
        User user = userService.getUser(userId);
        this.addCostPreference(user, cost);
        this.addCuisinePreference(user, cuisine);
    }

    public void addCostPreference(User user, Cost costBracket) {
        user.getCostFreq().putIfAbsent(costBracket, 0L);
        user.getCostFreq().replace(costBracket, user.getCostFreq().get(costBracket) + 1);
    }

    public void addCuisinePreference(User user, Cuisine cuisine) {
        user.getCuisineFreq().putIfAbsent(cuisine, 0L);
        user.getCuisineFreq().replace(cuisine, user.getCuisineFreq().get(cuisine) + 1);
    }

    public Cost getCostPreference(User user) {
        if (user.getCostFreq().isEmpty()) return null;
        return user.getCostFreq().entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public Cuisine getCuisinePreference(User user) {
        if (user.getCuisineFreq().isEmpty()) return null;
        return user.getCuisineFreq().entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

}
