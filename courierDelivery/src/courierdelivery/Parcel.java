/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courierdelivery;

/**
 *
 * @author fergus
 */
public class Parcel {
    //the name of the recipient
    String recipient;
    //the address of the delivery
    String address;
    //the weight of the parcel in kg
    int weight;
    
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    Parcel(String r,String a,int w){
        this.recipient = r;
        this.address = a;
        this.weight = w;
    }
    
    public String toString(){
        String output = "";
        output += "\nRecipient: '" + recipient + "'";
        output += ", Address: '" + address + "'";
        output += ", Weight: " + weight + "kg";
        return output;
    }
}
