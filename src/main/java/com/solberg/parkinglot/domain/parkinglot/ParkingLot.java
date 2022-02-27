/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.parkinglot;

import com.solberg.parkinglot.domain.spot.Size;
import com.solberg.parkinglot.domain.spot.Spot;
import com.solberg.parkinglot.domain.spot.SpotFactory;
import com.solberg.parkinglot.domain.spot.VehicleExceedsSpotSizeException;
import com.solberg.parkinglot.domain.vehicle.Vehicle;
import com.solberg.parkinglot.domain.vehicle.VehicleFactory;
import com.solberg.parkinglot.domain.vehicle.VehicleType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author dane
 */
public class ParkingLot {
    VehicleFactory vehicleFactory;
    SpotFactory spotFactory;
    Map<Integer, Spot> vehicleIdSpotMap;
    Map<Integer, Spot> spotIdSpotMap;
    
    NavigableMap<Integer, List<Spot>> availableSpots;
    int spotCount = 0;
    
    public ParkingLot() {
        availableSpots = new TreeMap<>();
        vehicleIdSpotMap = new HashMap<>();
        spotIdSpotMap = new HashMap<>();
        spotFactory = new SpotFactory();     
        vehicleFactory = new VehicleFactory();
        
    }
    
    public void addSpotSizeToMaxVehicleType(Size size, VehicleType type) {
        spotFactory.addSpotSizeToMaxVehicleType(size, type);
    }
    
    public void addSpots(Size size, int count) {
        int maxVehicleSize = spotFactory.getMaxVehicleTypeForSpotSize(size).value;
        if (!availableSpots.containsKey(maxVehicleSize)) {
            availableSpots.put(maxVehicleSize, new ArrayList<>());
        }
        List spotPoolForSize = availableSpots.get(maxVehicleSize);
        
        for (int i=0; i<count; i++) {
            spotCount++;
            Spot spot = spotFactory.createSpot(spotCount, size);
            spotPoolForSize.add(spot);
            spotIdSpotMap.put(spotCount, spot);
        }
    }
    
    private Spot getAvailableSpot(Vehicle vehicle) throws LotFullException {
        int vehicleSize = vehicle.getType().value;
        if (availableSpots.containsKey(vehicleSize) & !availableSpots.isEmpty()) {
            List pool = availableSpots.get(vehicleSize);
            return (Spot) pool.remove(pool.size() - 1);
        } else {
            while (vehicleSize != availableSpots.lastKey()) {
                vehicleSize = availableSpots.higherKey(vehicleSize);
                List pool = availableSpots.get(vehicleSize);
                if (!pool.isEmpty()) {
                    return (Spot) pool.remove(pool.size() - 1);
                }
            }
            throw new LotFullException();
        }
    }
    
    public Spot allocateSpot(VehicleType type) throws LotFullException {
        Vehicle vehicle = vehicleFactory.createVehicle(type);
        Spot spot = getAvailableSpot(vehicle);
        try {
            spot.addVehicle(vehicle);
        } catch (VehicleExceedsSpotSizeException e) {
            throw new RuntimeException("This shouldn't happen.");
        }
        
        vehicleIdSpotMap.put(spot.getVehicle().getId(), spot);
        return spot;
    }
    
    public Spot getSpotByVehicleId(int vehicleId) throws VehicleNotFoundException {
        Spot spot = vehicleIdSpotMap.get(vehicleId);
        if (spot == null) {
            throw new VehicleNotFoundException();
        }
        return spot;
    }
    
    public void deallocateSpot(int spotId) throws SpotNotFoundException {
        Spot spot = spotIdSpotMap.get(spotId);
        if (spot == null) {
            throw new SpotNotFoundException();
        }
        deallocateSpot(spot);
    }
    
    public void deallocateSpot(Spot spot) {
        Vehicle vehicle = spot.getVehicle();
        spot.removeVehicle();
        availableSpots.get(spot.getMaxVehicleSize().value).add(spot);
        vehicleIdSpotMap.remove(vehicle.getId());
    }
    
    public void printSpots() {
        for (Entry<Integer, Spot> entry:spotIdSpotMap.entrySet()) {
            Spot spot = entry.getValue();
            if (spot.getVehicle() == null) {
                System.out.println("Spot " + entry.getKey() + "(" + spot.getSpotSize() + "): Empty");
            } else {
                System.out.println("Spot " + entry.getKey() + "(" + spot.getSpotSize() + "): Vehicle " + spot.getVehicle().getId() + " " + spot.getVehicle().getType());
            }
        }
    }
}
