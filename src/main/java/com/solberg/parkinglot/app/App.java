/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.app;

import com.solberg.parkinglot.domain.parkinglot.LotFullException;
import com.solberg.parkinglot.domain.parkinglot.ParkingLot;
import com.solberg.parkinglot.domain.spot.Size;
import com.solberg.parkinglot.domain.spot.Spot;
import com.solberg.parkinglot.domain.vehicle.VehicleType;

/**
 *
 * @author dane
 */
public class App {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        
        parkingLot.addSpotSizeToMaxVehicleType(Size.SMALL, VehicleType.COMPACT);
        parkingLot.addSpotSizeToMaxVehicleType(Size.MEDIUM, VehicleType.MIDSIZE);
        parkingLot.addSpotSizeToMaxVehicleType(Size.LARGE, VehicleType.FULLSIZE);
        parkingLot.addSpotSizeToMaxVehicleType(Size.EXTRALARGE, VehicleType.BUS);
        
        parkingLot.addSpots(Size.SMALL, 5);
        parkingLot.addSpots(Size.MEDIUM, 5);
        parkingLot.addSpots(Size.LARGE, 2);
        parkingLot.addSpots(Size.EXTRALARGE, 1);
        
        try {
            Spot spot = parkingLot.allocateSpot(VehicleType.TRUCK);
            parkingLot.allocateSpot(VehicleType.COMPACT);
            parkingLot.allocateSpot(VehicleType.COMPACT);
            parkingLot.allocateSpot(VehicleType.COMPACT);
            parkingLot.allocateSpot(VehicleType.MIDSIZE);
            
            parkingLot.deallocateSpot(spot);
        } catch (LotFullException e) {
            System.out.println("Lot full.");
        }
        
        parkingLot.printSpots();
    }
}
