package org.n11.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.model.enums.BuildingTypes;

@Getter
@Setter
@NoArgsConstructor
public class SummerHouse extends Building{
    private boolean isPool;

    public SummerHouse(int id, BuildingTypes type, double price, int squareMeters, int numberOfRooms, int numberOfLivingRooms, boolean isPool) {
        super(id, type, price, squareMeters, numberOfRooms, numberOfLivingRooms);
        this.isPool = isPool;
    }
}
