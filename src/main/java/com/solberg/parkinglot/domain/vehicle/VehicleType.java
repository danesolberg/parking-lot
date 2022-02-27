/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.vehicle;

/**
 *
 * @author dane
 */
public enum VehicleType {
    COMPACT(0),
    MIDSIZE(1),
    FULLSIZE(2),
    TRUCK(3),
    BUS(4);
    
    public final int value;
    
    private VehicleType(int value) {
        this.value = value;
    }
}
