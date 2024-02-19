# Building Management System (JAVA 21)

This project is a simple real estate management system implemented in Java. It provides functionalities to create and manage different types of properties such as houses, villas, and summer houses.

## Overview

The project consists of the following components:

- **Models**: Classes representing different types of properties such as `House`, `Villa`, and `SummerHouse`.
- **Service**: A service class providing various functionalities for managing properties.
- **Main Class**: The entry point of the program where all functionalities are demonstrated.

## Functionalities

### 1. Buildings

- `House`: Represents a basic house with basic properties such as price, square meters, number of rooms, and number of living rooms.
- `Villa`: Represents a luxury villa with additional properties such as swimming pool, garden area, and garage space.
- `SummerHouse`: Represents a vacation house typically located in summer destinations with properties such as beach proximity and balcony area.

### 2. Service Methods

## Service Methods

### 1. getTotalPriceByBuildingType

**Description:** Calculates the total price of buildings of a specific type.

**Parameters:**
- `BuildingTypes buildingTypes`: The type of building to calculate the total price for.

**Returns:** Total price of buildings of the specified type.

### 2. getTotalPrice

**Description:** Calculates the total price of all buildings.

**Returns:** Total price of all buildings.

### 3. getAverageSquareMetersByBuildingType

**Description:** Calculates the average square meters of buildings of a specific type.

**Parameters:**
- `BuildingTypes buildingTypes`: The type of building to calculate the average square meters for.

**Returns:** Average square meters of buildings of the specified type.

### 4. getAverageSquareMeters

**Description:** Calculates the average square meters of all buildings.

**Returns:** Average square meters of all buildings.

### 5. filterBuildingByRoomAndLivingRoom

**Description:** Filters buildings based on the specified number of rooms and living rooms.

**Parameters:**
- `int numberOfRooms`: The number of rooms to filter by.
- `int numberOfLivingRooms`: The number of living rooms to filter by.

**Returns:** List of buildings that match the specified room and living room count.

## Usage

To use these methods, simply call them from an instance of the service class. For example:

## Contributions

Contributions to this project are welcome. If you have any suggestions or improvements, feel free to open an issue or submit a pull request.
