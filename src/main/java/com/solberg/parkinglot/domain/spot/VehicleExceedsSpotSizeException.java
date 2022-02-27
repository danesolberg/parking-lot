/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.spot;

/**
 *
 * @author dane
 */
public class VehicleExceedsSpotSizeException extends Exception {

    public VehicleExceedsSpotSizeException() {
        super("Vehicle too large for allocated spot.");
    }
    
}
