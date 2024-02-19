package org.n11.service.serviceImp;

import lombok.Getter;
import lombok.Setter;
import org.n11.model.Building;
import org.n11.model.House;
import org.n11.model.SummerHouse;
import org.n11.model.Villa;
import org.n11.model.enums.BuildingTypes;
import org.n11.service.service.BuildingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BuildingServiceImp implements BuildingSystem {
    private List<Building> buildingList= new ArrayList<>();

    public BuildingServiceImp() {
        buildingList.add(new House(1, BuildingTypes.HOUSE, 155000, 120, 3, 1, true));
        buildingList.add(new House(2, BuildingTypes.HOUSE, 277000, 276, 7, 2, false));
        buildingList.add(new House(3, BuildingTypes.HOUSE, 350000, 239, 4, 1, true));
        buildingList.add(new Villa(4, BuildingTypes.VILLA, 255000, 230, 8, 2, 2, false));
        buildingList.add(new Villa(5, BuildingTypes.VILLA, 178000, 196, 6, 1, 2, true));
        buildingList.add(new Villa(6, BuildingTypes.VILLA, 315000, 258, 11, 3, 3, true));
        buildingList.add(new SummerHouse(7, BuildingTypes.SUMMER_HOUSE, 243000, 193, 3, 1, true));
        buildingList.add(new SummerHouse(8, BuildingTypes.SUMMER_HOUSE, 287800, 229, 2, 1, false));
        buildingList.add(new SummerHouse(9, BuildingTypes.SUMMER_HOUSE, 220000, 283, 4, 1, true));

    }


    @Override
    public double getTotalPriceByBuildingType(BuildingTypes buildingTypes) {
        return buildingList.stream()
                .filter(building -> building.getType() == buildingTypes)
                .mapToDouble(Building::getPrice)
                .sum();
    }

    @Override
    public double getTotalPrice() {
        return buildingList.stream()
                .mapToDouble(Building::getPrice)
                .sum();
    }

    @Override
    public double getAverageSquareMetersByBuildingType(BuildingTypes buildingTypes) {
        return buildingList.stream()
                .filter(building -> building.getType() == buildingTypes)
                .mapToDouble(Building::getSquareMeters)
                .average()
                .orElse(0);
    }

    @Override
    public double getAverageSquareMeters() {
        return buildingList.stream()
                .mapToDouble(Building::getSquareMeters)
                .average()
                .orElse(0);
    }

    @Override
    public List<Building> filterBuildingByRoomAndLivingRoom(int numberOfRooms, int numberOfLivingRooms) {
        return buildingList.stream()
                .filter(building -> building.getNumberOfRooms() == numberOfRooms && building.getNumberOfLivingRooms() == numberOfLivingRooms)
                .collect(Collectors.toList());
    }
}
