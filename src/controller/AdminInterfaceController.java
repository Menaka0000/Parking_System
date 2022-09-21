package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.DataBase;
import models.Driver;
import models.Vehicle1;

import java.io.IOException;
import java.net.URL;


public class AdminInterfaceController extends DataBase {



    public JFXButton btnDelivery;
    public AnchorPane contextAnchorPane;
    public Circle Image1;
    public Circle Image2;
    public Circle Image3;
    public Circle Image4;
    public Label lblBasement;
    public Label lblDelivery;
    public Label lblDriver;
    public Label lblTotal;

    public void initialize(){
        if(getTotalDriver()!=0){ lblDriver.setText(Integer.toString(getTotalDriver()));}
        if(getTotalVehicle()!=0){lblTotal.setText(Integer.toString(getTotalVehicle()));}
        if(getVehicleOnDe()!=0){lblDelivery.setText(Integer.toString(getVehicleOnDe()));}
        if(getTotalVehicle()!=0){lblBasement.setText(Integer.toString(getTotalVehicle()-getVehicleOnDe()));}

        Image1.setStroke(Color.SEAGREEN);
        Image2.setStroke(Color.SEAGREEN);
        Image3.setStroke(Color.SEAGREEN);
        Image4.setStroke(Color.SEAGREEN);
        Image im1 =new Image("assets/1.jpg",false);
        Image im2 =new Image("assets/photo-1557230969-60807a515577.jpg",false);
        Image im3 =new Image("assets/5.jpg",false);
        Image im4 =new Image("assets/2.jpg",false);
        Image1.setFill(new ImagePattern(im1));
        Image2.setFill(new ImagePattern(im2));
        Image3.setFill(new ImagePattern(im3));
        Image4.setFill(new ImagePattern(im4));



    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource=getClass().getResource("../view/DashBoard.fxml");
        Parent load= FXMLLoader.load(resource);
        Stage stage1 =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(load);
        stage1.setScene(scene);
        stage1.show();
    }

    public void OnDelivery(MouseEvent mouseEvent) {
        FadeTransition fade = new FadeTransition();
        fade.setNode(btnDelivery);

        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(.1);
        fade.play();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load =FXMLLoader.load(resource);
        contextAnchorPane.getChildren().clear();
        contextAnchorPane.getChildren().add(load);
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load =FXMLLoader.load(resource);
        contextAnchorPane.getChildren().clear();
        contextAnchorPane.getChildren().add(load);
    }

    public void exitOnAction(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void parkedOnaction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/InParking.fxml");
        Parent load =FXMLLoader.load(resource);
        contextAnchorPane.getChildren().clear();
        contextAnchorPane.getChildren().add(load);
    }

    public void onDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OnDelivery.fxml");
        Parent load =FXMLLoader.load(resource);
        contextAnchorPane.getChildren().clear();
        contextAnchorPane.getChildren().add(load);
    }

    public void VehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/VehicleTable.fxml");
        Parent load =FXMLLoader.load(resource);
        contextAnchorPane.getChildren().clear();
        contextAnchorPane.getChildren().add(load);
    }

    public void driverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriverTable.fxml");
        Parent load =FXMLLoader.load(resource);
        contextAnchorPane.getChildren().clear();
        contextAnchorPane.getChildren().add(load);

    }
}
