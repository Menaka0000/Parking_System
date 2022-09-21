package models;

import javafx.scene.control.ComboBox;

import java.util.Arrays;

public class Van extends DataBase implements Vehicle1 {

    public int reservedSlotsVan;
    String vehicleNumber ;
    String vehicleType;
    String maximumWeight;
    String numOfPassengers;
    String driverNIC;
    String leftTime;
    String parkedTime;
    static int vanCount=0;

    public Van(int reservedSlotsVan, String vehicleNumber, String vehicleType, String maximumWeight, String numOfPassengers, String driverNIC,String leftTime, String parkedTime) {
        this.reservedSlotsVan = reservedSlotsVan;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
        this.driverNIC = driverNIC;
        this.leftTime = leftTime;
        this.parkedTime = parkedTime;
    }

    @Override
    public void parkVehicle(Vehicle1 y ,String vehicleNum) {
        if (y.getVehicleNumber().equals(vehicleNum)) {
            vehicleSlotID[y.getReservedSlotsVan()-1]=y.getVehicleNumber();
            Arrays.sort(vanSlotArray);
            for (int k=0; k<vanSlotArray.length; k++){
                if(vanSlotArray[k]!=0){
                    vanSlotArray[k]=0;
//                    System.out.println("Park method of bla bla van called");
                    driverReset(y);
                    y.setParkedTime(formatter.format(date));
                    break;
                }
            }
            // break;
        }
    }

    @Override
    public void leavePark(Vehicle1 x , String vehicleNum, ComboBox cmboDriver) {
        if (x.getVehicleNumber().equals(vehicleNum)) {
            vehicleSlotID[x.getReservedSlotsVan()-1] = null;
            x.setLeftTime(formatter.format(date));
            for (Driver a : DriverArray) {
                if (((String) cmboDriver.getValue()).equals(a.getDriverName())) {
                    x.setDriverNIC(a.getNIC());
                    onDeliveryDrivers[onDeliveryArrayCount++]=a.getDriverName();
                    if(onDeliveryArrayCount==14){onDeliveryArrayCount=0;}
                    break;
                }
            }
            vanSlotArray[vanCount++] = x.getReservedSlotsVan();
            if (vanCount == 6) {
                vanCount = 0;
            }
//            System.out.println(Arrays.toString(vanSlotArray));
//            System.out.println("A van on delivery Successfully");

        }
    }

//    public void setReservedSlotsVan(int reservedSlotsVan) {
//
//        this.reservedSlotsVan = reservedSlotsVan;
//    }
//
//    public void setVehicleNumber(String vehicleNumber) {
//        this.vehicleNumber = vehicleNumber;
//    }
//
//    public void setVehicleType(String vehicleType) {
//        this.vehicleType = vehicleType;
//    }
//
//    public void setMaximumWeight(String maximumWeight) {
//        this.maximumWeight = maximumWeight;
//    }
//
//    public void setNumOfPassengers(String numOfPassengers) {
//        this.numOfPassengers = numOfPassengers;
//    }
//
    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }

    public int getReservedSlotsVan() {
        return reservedSlotsVan;
    }

    @Override
    public int getReservedSlotsLorry() {
        return 0;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getMaximumWeight() {
        return maximumWeight;
    }

    public String getNumOfPassengers() {
        return numOfPassengers;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    @Override
    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public String getParkedTime() {
        return parkedTime;
    }

}
