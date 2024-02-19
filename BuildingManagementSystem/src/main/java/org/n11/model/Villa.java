package org.n11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.model.enums.BuildingTypes;

@Getter
@Setter
@NoArgsConstructor
public class Villa extends Building{
    private int numberOfFloors;
    private boolean isPool;

    public Villa(int id, BuildingTypes type, double price, int squareMeters, int numberOfRooms, int numberOfLivingRooms, int numberOfFloors, boolean isPool) {
        super(id, type, price, squareMeters, numberOfRooms, numberOfLivingRooms);
        this.numberOfFloors = numberOfFloors;
        this.isPool = isPool;
    }
}
