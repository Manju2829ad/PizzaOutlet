package basepackage.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class VegPizza extends Pizza {
    private String veggieType; // e.g. mushroom, onion, etc.
    private boolean isGlutenFree;
    // Getters and setters
}
