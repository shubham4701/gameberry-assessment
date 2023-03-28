package restaurant.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private final String id;
    private final Map<Cuisine, Long> cuisineFreq;
    private final Map<Cost, Long> costFreq;

    public User() {
        this.id = UUID.randomUUID().toString();
        cuisineFreq = new EnumMap<>(Cuisine.class);
        costFreq = new EnumMap<>(Cost.class);
    }

    public String getId() {
        return id;
    }

    public Map<Cuisine, Long> getCuisineFreq() {
        return cuisineFreq;
    }

    public Map<Cost, Long> getCostFreq() {
        return costFreq;
    }
}
