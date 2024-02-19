package org.n11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.model.enums.BuildingTypes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    private int id;
    private BuildingTypes type;
    private double price;
    private int squareMeters;
    private int numberOfRooms;
    private int numberOfLivingRooms;


}
