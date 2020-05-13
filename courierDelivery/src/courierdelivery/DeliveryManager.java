/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courierdelivery;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.*;

/**
 *
 * @author fergus
 */
public class DeliveryManager {
    
    private Queue<Parcel> parcels;
    private List<Driver> drivers;
    private HashMap<Parcel, Driver> deliveries;
    private HashMap<Driver, List<Parcel>> loads;
    
    DeliveryManager(){
        parcels = new LinkedList<>();
        drivers = new ArrayList<>();
        deliveries = new HashMap<>();
        loads = new HashMap<>();
    }
    
    public void allocateParcels(){
        Driver driver = drivers.get(0);
        int lowest = driver.getNumberParcels();
        int size = parcels.size();
        for(int i = 0; i<size; i++){
            Parcel parcel = parcels.remove();
            for(int j = 0; j < drivers.size(); j++){
                if(drivers.get(j).getNumberParcels() < lowest){
                    driver = drivers.get(j);
                    lowest = driver.getNumberParcels();
                }
            }
            lowest++;
            driver.setNumberParcels(lowest);
            deliveries.put(parcel, driver);
            loads.get(driver).add(parcel);
        }
        
    }
    
    public void addUrgentParcel(Parcel p){
            Queue<Parcel> newQueue = new LinkedList<>();
            newQueue.add(p);
            newQueue.addAll(this.parcels);
            this.parcels = newQueue;
    }
    
    public Parcel nextParcel(Queue<Parcel> parcel){
        return parcel.remove();
    }
    
    public void addDriver(Driver driver){
        drivers.add(driver);
        List<Parcel> loadsList = new ArrayList<>();
        loads.put(driver, loadsList);
    }
    
    public void addParcel(Parcel parcel){
        parcels.add(parcel);
    }
    
    @Override
    public String toString(){
        String output = "";
        output += parcels.toString();
        output += drivers.toString();
        output += deliveries.toString();
        return output;
    }
    
    public void printByParcel(){
        deliveries.keySet().stream()
                .sorted(Comparator.comparing(Parcel::getAddress))
                .forEach(p -> System.out.println("\nParcel:" + p.toString() + "\nDriver: " + deliveries.get(p)));
        
        parcels.stream()
                .sorted(Comparator.comparing(Parcel::getAddress))
                .forEach(p -> System.out.println("\nParcel:" + p.toString() + "\nDriver: No Driver Allocated."));
    }
    
    public void printByDriver(){
        drivers.stream()
                .sorted(Comparator.comparing(Driver::getName))
                .forEach(d -> System.out.println("\nDriver:" + d.toString() + " " + loads.get(d).toString()));
    }
}
