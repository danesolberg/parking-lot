/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.vehicle;

/**
 *
 * @author dane
 */
public class Vehicle {
    private VehicleType type;
    private int id;

    public Vehicle(VehicleType type, int id) {
        this.type = type;
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }
    
    public Vehicle(int id) {
        this.id = id;
    }
}
