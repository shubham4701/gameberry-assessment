package restaurant.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Assumption - A restaurant specialises in one cuisine and one cost bracket only
 */
public class Restaurant {
    private final String id;
    private final Cuisine cuisine;
    private final Cost costBracket;
    private final Float rating;
    private final Boolean isRecommended;

    public String getId() {
        return id;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Cost getCostBracket() {
        return costBracket;
    }

    public float getRating() {
        return rating;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public LocalDateTime getOnboardedTime() {
        return onboardedTime;
    }

    private final LocalDateTime onboardedTime;

    public Restaurant(Cuisine cuisine, Cost costBracket, Float rating, Boolean isRecommended) {
        this.id = UUID.randomUUID().toString();
        this.cuisine = cuisine;
        this.costBracket = costBracket;
        this.rating = rating;
        this.isRecommended = isRecommended;
        this.onboardedTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", cuisine=" + cuisine +
                ", costBracket=" + costBracket +
                ", rating=" + rating +
                ", isRecommended=" + isRecommended +
                ", onboardedTime=" + onboardedTime +
                '}';
    }
}
