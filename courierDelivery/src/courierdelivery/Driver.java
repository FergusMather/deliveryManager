/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courierdelivery;

import java.util.Comparator;

/**
 *
 * @author fergus
 */
public class Driver implements Comparable<Driver>{
    

    
    String name;
    int numberParcels;
    
    Driver(String name){
        this.name = name;
        this.numberParcels = 0;
    }
    
    public void incrementNumberParcels(){
        this.numberParcels ++;
    }
    
    public int compareTo(Driver driver){
        return this.name.compareTo(driver.name);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberParcels() {
        return numberParcels;
    }

    public void setNumberParcels(int numberParcels) {
        this.numberParcels = numberParcels;
    }
    
    public String toString(){
        String output = "";
        output += "\nName: '" + name + "'";
        output += ", Number of Parcels: " + numberParcels;
        return output;
    }

    public static class CompareDriverLoad implements Comparator<Driver>{
        
        @Override
        public int compare(Driver driverA, Driver driverB) {
            if (driverA.getNumberParcels() > driverB.getNumberParcels()) {
                return 1;
            }
            if (driverA.getNumberParcels() < driverB.getNumberParcels()) {
                return -1;
            }
            else return 0;
        }              
        
    }
    
}
