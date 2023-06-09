package com.example.beatflow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InitController {

    @FXML
    Button adminBtn, userBtn;
    @FXML
    protected void onAdminButtonClick(){
        Stage window = (Stage) adminBtn.getScene().getWindow();
        window.setScene(BeatFlow.adminScene);
    }

    @FXML
    protected void onUserButtonClick(){
        Stage window = (Stage) userBtn.getScene().getWindow();
        window.setScene(BeatFlow.userScene);
    }
}
