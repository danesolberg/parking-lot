/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.spot;

import com.solberg.parkinglot.domain.vehicle.VehicleType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dane
 */
public class SpotFactory {
    Map<Size, VehicleType> maxVehicleTypeForSpotSize;

    public SpotFactory() {
        this.maxVehicleTypeForSpotSize = new HashMap<>();
    }
    
    public void addSpotSizeToMaxVehicleType(Size size, VehicleType type) {
        maxVehicleTypeForSpotSize.put(size, type);
    }
    
    public VehicleType getMaxVehicleTypeForSpotSize(Size size) {
        if (maxVehicleTypeForSpotSize.containsKey(size)) {
            return maxVehicleTypeForSpotSize.get(size);
        } else {
            throw new RuntimeException("Mapping for vehicle type to spot size required.");
        }
    }
    
    public Spot createSpot(int spotId, Size size) {
        VehicleType type = getMaxVehicleTypeForSpotSize(size);
        switch (size) {
            case SMALL:
                return new Spot(spotId, size, type);
            case MEDIUM:
                return new Spot(spotId, size, type);
            case LARGE:
                return new Spot(spotId, size, type);
            case EXTRALARGE:
                return new Spot(spotId, size, type);
            default:
                throw new RuntimeException("Invalid size chosen for Spot creation.");
        }
    }
}
