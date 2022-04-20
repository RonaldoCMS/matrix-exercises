package com.example;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PrimaryController {

    @FXML
    private TextField txtCelsius;

    @FXML
    private TextField txtKelvin;

    @FXML
    void handleKeyReleased(KeyEvent event) {
        if(txtCelsius.getText().equals("")) {
            txtKelvin.setText("");
        } else {
            DecimalFormat df = new DecimalFormat("0.000");
            String value = txtCelsius.getText();
            try {
                double doubleCelsius = Double.parseDouble(value);
                double result = doubleCelsius  + 273.15;
                txtKelvin.setText("" + df.format(result));
            } catch(Exception e) {
                txtKelvin.setText("");
            }
        }
    }

}
