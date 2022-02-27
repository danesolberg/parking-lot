/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.spot;

import com.solberg.parkinglot.domain.vehicle.Vehicle;
import com.solberg.parkinglot.domain.vehicle.VehicleType;

/**
 *
 * @author dane
 */
public class Spot {
    private int spotId;
    private VehicleType maxVehicleSize;
    private Size spotSize;
    private Vehicle vehicle = null;
    
    public Spot(int spotId, Size spotSize, VehicleType maxVehicleSize) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.maxVehicleSize = maxVehicleSize;
    }

    public Size getSpotSize() {
        return spotSize;
    }
    
    private boolean validateFit(Vehicle vehicle) {
        return vehicle.getType().value <= maxVehicleSize.value;
    }
    
    public VehicleType getMaxVehicleSize() {
        return maxVehicleSize;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void addVehicle(Vehicle vehicle) throws VehicleExceedsSpotSizeException {
        if (validateFit(vehicle)) {
            this.vehicle = vehicle;
        } else {
            throw new VehicleExceedsSpotSizeException();
        }
    }
    
    public void removeVehicle() {
        vehicle = null;
    }
}
