module com.example.beatflow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.beatflow to javafx.fxml;
    exports com.example.beatflow;
}