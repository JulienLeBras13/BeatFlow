package com.example.beatflow;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Account;

public class InitController {

    @FXML
    private Button loginBtn;
    @FXML
    private Label id, password, errorID, errorPassword;
    @FXML
    private TextField idInput, passwordInput;


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
