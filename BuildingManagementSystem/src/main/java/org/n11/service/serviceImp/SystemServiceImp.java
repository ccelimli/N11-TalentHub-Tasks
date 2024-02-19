package org.n11.service.serviceImp;

import lombok.RequiredArgsConstructor;
import org.n11.model.Building;
import org.n11.model.enums.BuildingTypes;
import org.n11.service.service.BuildingSystem;
import org.n11.service.service.SystemService;

import java.lang.reflect.Field;
import java.util.Scanner;

@RequiredArgsConstructor
public class SystemServiceImp implements SystemService {
    private final Scanner input = new Scanner(System.in);
    private final BuildingSystem buildingSystem;

    @Override
    public void start() {
        System.out.println("Hoşgeldiniz");

        while (true) {
            System.out.println("İşlemler");
            System.out.println("1 - Ev İşlemleri");
            System.out.println("2 - Villa İşlemleri");
            System.out.println("3 - Yazlık İşlemleri");
            System.out.println("4 - Tüm Evler");
            System.out.println("0 - Çıkış Yap");
            System.out.println("Seçim : ");

            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0 -> {
                    System.out.println("Hoşçakal");
                    return;
                }
                case 1 -> selectionsByBuildingType(BuildingTypes.HOUSE);
                case 2 -> selectionsByBuildingType(BuildingTypes.VILLA);
                case 3 -> selectionsByBuildingType(BuildingTypes.SUMMER_HOUSE);
                case 4 -> selectionsByBuildingType(null);
                default -> throw new IllegalStateException("Unexpected value: " + selectLoc);
            }
        }
    }

    private void selectionsByBuildingType(BuildingTypes buildingTypes) {
        if (buildingTypes == null) {
            while (true) {
                System.out.println("1 - Toplam Fiyatlar");
                System.out.println("2 - Ortalama Metrekare");
                System.out.println("3 - Oda ve Salon Sayısına Göre Evler");
                System.out.println("0 - Çıkış Yap");

                int value = input.nextInt();
                while (value < 0 || value > 3) {
                    System.out.println("Geçersiz değer");
                    value = input.nextInt();
                }

                switch (value) {
                    case 0 -> {
                        System.out.println("Hoşçakal");
                        return;
                    }
                    case 1 -> System.out.println(buildingSystem.getTotalPrice());
                    case 2 -> System.out.println(buildingSystem.getAverageSquareMeters());
                    case 3 -> {
                        System.out.println("Oda Sayısı: ");
                        int numberOfRoom = input.nextInt();
                        System.out.println("Salon Sayısı: ");
                        int numberOfLivingRoom = input.nextInt();
                        System.out.println("\n\n");

                      for (Building building : buildingSystem.filterBuildingByRoomAndLivingRoom(numberOfRoom,numberOfLivingRoom)){
                          Class<? extends Building> builds=building.getClass();
                          while(builds!=null){
                              for (Field field: builds.getDeclaredFields()){
                                  try {
                                      field.setAccessible(true);
                                      Object build=field.get(building);

                                      System.out.println(field.getName() + ": " + build);
                                  } catch (IllegalAccessException e) {
                                      throw new RuntimeException(e);
                                  }
                              }
                              builds= (Class<? extends Building>) builds.getSuperclass();
                          }
                          System.out.println("\n\n");
                      }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + value);
                }
            }
        }

        while (true) {
            System.out.println("1 - " + buildingTypes.getStringValue() + " Toplam Fiyatları:");
            System.out.println("2 - " + buildingTypes.getStringValue() + " Ortalama Metrekare: ");
            System.out.println("0 - Çıkış Yap.");

            int value = input.nextInt();

            while (value < 0 || value > 2) {
                System.out.println("Geçersiz değer");
                value = input.nextInt();
            }
            switch (value) {
                case 0 -> {
                    start();
                }
                case 1 -> System.out.println(buildingSystem.getTotalPriceByBuildingType(buildingTypes));
                case 2 -> System.out.println(buildingSystem.getAverageSquareMetersByBuildingType(buildingTypes));
            }
        }
    }
}
