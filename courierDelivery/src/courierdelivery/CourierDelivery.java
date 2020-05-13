/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courierdelivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author driverOne
 */
public class CourierDelivery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parcel firstParcel = new Parcel("Fergus", "Aberdeen", 70);
        Driver driverOne = new Driver("Fergus");
        Driver driverTwo = new Driver("Malcolm");
        Driver driverThree = new Driver("Duncan");
        Driver driverFour = new Driver("Cara");
        Driver driverFive = new Driver("Anne");
        Driver driverSix = new Driver("Angus");
        //System.out.println(firstParcel.toString());
        ArrayList<Driver> listOne = new ArrayList<>();
        listOne.add(driverOne);
        listOne.add(driverTwo);        
        listOne.add(driverThree);
        
        //System.out.println(listOne.toString());
        
        List<Driver> listTwo = new LinkedList<>();
        listTwo.add(driverFour);
        listTwo.add(driverSix);
        listTwo.add(driverFive);
        //System.out.println(listTwo.toString());
        
        listOne.addAll(listTwo);
        //System.out.println(listOne.toString());
        
        Collections.sort(listOne);
        //System.out.println(listOne.toString());
        
        Collections.sort(listOne, Collections.reverseOrder());
        //System.out.println(listOne.toString());
        
        Set<Driver> setOne = new TreeSet<>();
        setOne.add(driverOne);
        setOne.add(driverTwo);
        setOne.add(driverThree);
        //System.out.println(setOne.toString());
        
        Set<Driver> setTwo = new TreeSet<>();
        setTwo.add(driverOne);
        setTwo.add(driverTwo);
        setTwo.add(driverFour);
        setTwo.add(driverFive);
        //System.out.println(setTwo.toString());
        
        Set OneIntersectTwo = new TreeSet(setOne);
        OneIntersectTwo.retainAll(setTwo);
        //System.out.println(OneIntersectTwo.toString());
        
        Set OneDifferenceTwo = new TreeSet(setOne);
        OneDifferenceTwo.removeAll(setTwo);
        //System.out.println(OneDifferenceTwo.toString());
        
        DeliveryManager manager = new DeliveryManager();
        Parcel parcelOne = new Parcel("Amber","Aberdeen",12);
        Parcel parcelTwo = new Parcel("Glen", "Glasgow", 30);
        Parcel parcelThree = new Parcel("Edward", "Edinburgh", 45);
        Parcel parcelFour = new Parcel("David", "Dundee", 50);
        manager.addDriver(driverOne);
        manager.addDriver(driverTwo);
        manager.addDriver(driverThree);
        manager.addParcel(parcelOne);
        manager.addParcel(parcelTwo);
        manager.addParcel(parcelThree);
        manager.addParcel(parcelFour);
        //System.out.println(manager.toString());
        manager.allocateParcels();
        //manager.addParcel(parcelFour);
        manager.printByDriver();
        //manager.printByParcel();        
    }
    
    
}
