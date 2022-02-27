/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solberg.parkinglot.domain.parkinglot;

/**
 *
 * @author dane
 */
public class LotFullException extends Exception {

    public LotFullException() {
        super("No available spots for vehicle.");
    }
    
}
