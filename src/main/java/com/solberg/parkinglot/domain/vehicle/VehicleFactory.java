/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.vehicle;

/**
 *
 * @author dane
 */
public class VehicleFactory {
    private int runningVehicleCount = 0;
    
    public Vehicle createVehicle(VehicleType type) {
        runningVehicleCount++;
        return new Vehicle(type, runningVehicleCount);
    }
}
