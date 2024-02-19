package org.n11.model.enums;

public enum BuildingTypes {
    HOUSE("Ev"),
    VILLA ("Villa"),
    SUMMER_HOUSE("Yazlık");

    private String stringValue;

    BuildingTypes(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
