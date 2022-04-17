module com.matrix {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.matrix.controller to javafx.fxml;
    opens com.matrix.model;


    exports com.matrix;
}
