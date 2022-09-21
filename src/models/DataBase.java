package models;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBase {
    static int onDeliveryArrayCount=0;
    public static Vehicle1[] vanArray=new Vehicle1[6];
    public static Vehicle1[] busArray=new Vehicle1[1];
    public static Vehicle1[] cargoLorryArray=new Vehicle1[7];

    public static Driver[] DriverArray=new Driver[16];

    public static int[] vanSlotArray=new int[6];
    public static int[] lorrySlotArray=new int[7];
    public static String[] vehicleSlotID=new String[14];
    public static String [] onDeliveryDrivers=new String[14];

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss  a");
    Date date = new Date();

    public void driverReset(Vehicle1 y){
        for(Driver p : DriverArray){
            if(p!=null){
                for(int i=0;i<onDeliveryDrivers.length;i++){
                    if(onDeliveryDrivers[i]!=null){
                        if(onDeliveryDrivers[i].equals(p.getDriverName())){onDeliveryDrivers[i]=null;};
                        break;
                    }
                }
                if(p.getNIC().equals(y.getDriverNIC())){
                    y.setDriverNIC(null);
                    break;
                }
            }
        }
    }
    public void makeNotification(String note){
        Notifications notificationBuilder =Notifications.create()
                .title("Warning")
                .text(note)
                .graphic(null)
                .hideAfter(Duration.millis(5000))
                .position(Pos.TOP_CENTER);
        notificationBuilder.showWarning();
    }
    public void makeAlertNotification(String note){
        Notifications notificationBuilder =Notifications.create()
                .title("Alert")
                .text(note)
                .graphic(null)
                .hideAfter(Duration.millis(2000))
                .position(Pos.TOP_CENTER);
        notificationBuilder.show();
    }

    public int getTotalDriver(){
        int count=0;
        for(Driver x :DriverArray){
            if(x!=null){
                count++;
            }else{break;}
        }return count;
    }

    public int getTotalVehicle (){
        int count=0;
        for(Vehicle1 x :vanArray){
            if(x!=null){
                count++;
            }else {break;}
        }
        for(Vehicle1 y :cargoLorryArray){
            if(y!=null){
                count++;
            }else {break;}
        }
        if(busArray[0]!=null){count++;}
        return count;
    }


    public int getVehicleOnDe(){
        int count=0;
        for(String x :onDeliveryDrivers){
            if(x!=null){
                count++;
            }
        }return count;
    }
}
