package models;

import javafx.scene.control.ComboBox;

import java.util.Arrays;

public class CargoLorry extends DataBase implements Vehicle1 {
   public int reservedSlotsLorry;
   String vehicleNumber ;
   String vehicleType;
   String maximumWeight;
   String numOfPassengers;
   String driverNIC;
   static int lorryCount=0;
   String leftTime;
   String parkedTime;

   public CargoLorry(int reservedSlotsLorry, String vehicleNumber, String vehicleType, String maximumWeight, String numOfPassengers, String driverNIC,String leftTime, String parkedTime) {
      this.reservedSlotsLorry = reservedSlotsLorry;
      this.vehicleNumber = vehicleNumber;
      this.vehicleType = vehicleType;
      this.maximumWeight = maximumWeight;
      this.numOfPassengers = numOfPassengers;
      this.driverNIC = driverNIC;
      this.leftTime = leftTime;
      this.parkedTime = parkedTime;
   }

   @Override
   public void parkVehicle(Vehicle1 z ,String vehicleNum) {
      if (z.getVehicleNumber().equals(vehicleNum)) {
         vehicleSlotID[z.getReservedSlotsLorry()-1]=z.getVehicleNumber();
         Arrays.sort(lorrySlotArray);
         for (int i=0;  i<lorrySlotArray.length; i++) {
            if (lorrySlotArray[i] != 0) {
               lorrySlotArray[i]=0;
               System.out.println("Park method of bla bla lorry called");
               driverReset(z);
               z.setParkedTime(formatter.format(date));
               break;
            }
         }
         //break;
      }
   }

   @Override
   public void leavePark(Vehicle1 c, String vehicleNum, ComboBox cmboDriver) {
      if(c.getVehicleNumber().equals(vehicleNum)){
//                        System.out.println(c.getReservedSlotsLorry());
//                        System.out.println(Arrays.toString(vehicleSlotID));
//                        System.out.println(vehicleSlotID[c.getReservedSlotsLorry()]);
         vehicleSlotID[c.getReservedSlotsLorry()-1]=null;
         c.setLeftTime(formatter.format(date));
//                        System.out.println(vehicleSlotID[c.getReservedSlotsLorry()]);
//                        System.out.println(Arrays.toString(vehicleSlotID));
         for (Driver b : DriverArray) {
            if(b!=null){
               if (((String) cmboDriver.getValue()).equals(b.getDriverName())) {
                  c.setDriverNIC(b.getNIC());
                  onDeliveryDrivers[onDeliveryArrayCount++]=b.getDriverName();
                  if(onDeliveryArrayCount==14){onDeliveryArrayCount=0;}
                  break;
               }
            }
         }
         lorrySlotArray[lorryCount++] = c.getReservedSlotsLorry();
         if (lorryCount == 7) {
            lorryCount = 0;
         }
//         System.out.println(Arrays.toString(lorrySlotArray));
//         System.out.println("A Lorry Added Successfully");
      }
   }
   public int getReservedSlotsLorry() {
      return reservedSlotsLorry;
   }

   public String getVehicleNumber() {
      return vehicleNumber;
   }
   @Override
   public void setDriverNIC(String driverNIC) {
      this.driverNIC = driverNIC;
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

   @Override
   public int getReservedSlotsVan() {
      return 0;
   }

   public String getLeftTime() {
      return leftTime;
   }

   public String getParkedTime() {
      return parkedTime;
   }
}
