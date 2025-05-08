module com.example.fortuneteller {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fortuneteller to javafx.fxml;
    exports com.example.fortuneteller;
}