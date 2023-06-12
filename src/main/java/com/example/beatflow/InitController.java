package com.example.beatflow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Account;

import java.io.File;


public class InitController {


    @FXML
    Button loginBtn;
    @FXML
    Label id, password, errorID, errorPassword;
    @FXML
    TextField idInput, passwordInput;

    @FXML
    protected  void onLoginBtnClick(){
        boolean idCheck = false;
        boolean passwordCheck = false;

        int index = 0;

        for (Account account : BeatFlow.accounts) {
            if (account.getId().equals(idInput.getText())){
                idCheck = true;
                if (account.getPassword().equals(passwordInput.getText())) {
                    passwordCheck = true;
                    index = BeatFlow.accounts.indexOf(account);
                }
                break;
            }
        }

        if (idCheck && passwordCheck){
            if (BeatFlow.accounts.get(index).getAdmin()){
                Stage window = (Stage) loginBtn.getScene().getWindow();
                window.setScene(BeatFlow.adminScene);
            } else {
                Stage window = (Stage) loginBtn.getScene().getWindow();
                window.setScene(BeatFlow.userScene);
            }
        } else {
            if (!idCheck){
                errorID.setText("ID NOT FOUND !");
                errorID.setTextFill(Color.RED);
            } else {
                errorID.setTextFill(Color.BLACK);
                errorID.setText("Enter your ID");
            }
            if (!passwordCheck){
                errorPassword.setText("WRONG PASSWORD !");
                errorPassword.setTextFill(Color.RED);
            } else {
                errorPassword.setTextFill(Color.BLACK);
                errorPassword.setText("Enter your password");
            }
        }
    }
}
