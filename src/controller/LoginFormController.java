package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController  {
    public TextField txtUserName;
    public TextField txtPassword;
    public ImageView closeImage;
    public JFXButton btnCancel;
    public JFXButton btnLogin;
    public Label lblError;

    public void Cancel(ActionEvent actionEvent) throws IOException {
        URL resource=getClass().getResource("../view/DashBoard.fxml");
        Parent load= FXMLLoader.load(resource);
        Stage stage1 =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(load);
        stage1.setScene(scene);
        stage1.show();
    }

    public void LogIn(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("Admin") &&txtPassword.getText().equals("1234")){
            Stage stage=(Stage) btnLogin.getScene().getWindow();
            stage.close();
            URL resource=getClass().getResource("../view/AdminInterface.fxml");
            Parent load= FXMLLoader.load(resource);
            Stage stage1 =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene=new Scene(load);
            stage1.setScene(scene);
            stage1.show();

        }else{
            lblError.setText("Invalid User Name Or Password");
        }

    }

    public void imgClose(MouseEvent mouseEvent) {
    }
}
