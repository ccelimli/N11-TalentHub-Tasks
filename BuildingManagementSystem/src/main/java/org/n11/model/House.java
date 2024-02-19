package org.n11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.model.enums.BuildingTypes;

@Getter
@Setter
@NoArgsConstructor
public class House extends Building {
    private boolean isDetached;

    public House(int id, BuildingTypes type, double price, int squareMeters, int numberOfRooms, int numberOfLivingRooms, boolean isDetached) {
        super(id, type, price, squareMeters, numberOfRooms, numberOfLivingRooms);
        this.isDetached = isDetached;
    }
}
