module org.example.fuelconsumption {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.fuelconsumption to javafx.fxml;
    exports org.example.fuelconsumption;
}