package org.example.ParkingLot.Services;

import java.util.List;

public interface IparkingService {
    void createParkingLot(List<String> tokens);
    void parkVehicle(List<String> tokens);
    void unparkVehicle(List<String>tokens);
}
