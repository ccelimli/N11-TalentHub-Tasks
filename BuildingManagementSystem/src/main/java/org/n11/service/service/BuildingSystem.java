package org.n11.service.service;

import org.n11.model.Building;
import org.n11.model.enums.BuildingTypes;

import java.util.List;


public interface BuildingSystem {
    double getTotalPriceByBuildingType(BuildingTypes buildingTypes);

    double getTotalPrice();

    double getAverageSquareMetersByBuildingType(BuildingTypes buildingTypes);

    double getAverageSquareMeters();

    List<Building> filterBuildingByRoomAndLivingRoom(int numberOfRooms, int numberOfLivingRooms);
}
