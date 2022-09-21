package models;

import javafx.scene.control.ComboBox;

public interface Vehicle1 {
//      String vehicleNumber = null;
//      String vehicleType=null;
//      int maximumWeight=0;
//      int numOfPassengers=0;
//      String driverNIC=null;

        int getReservedSlotsVan();
        int getReservedSlotsLorry();
        String getVehicleNumber();
        void setDriverNIC(String driverNIC);
        String getDriverNIC();
        void setLeftTime(String leftTime) ;
        void setParkedTime(String parkedTime);
        String getLeftTime();
        String getParkedTime();
        String getVehicleType();
        String getMaximumWeight();
        String getNumOfPassengers();
        void parkVehicle(Vehicle1 y ,String vehicleNum);
        void leavePark(Vehicle1 y , String vehicleNum, ComboBox cmboDriver);
    }

