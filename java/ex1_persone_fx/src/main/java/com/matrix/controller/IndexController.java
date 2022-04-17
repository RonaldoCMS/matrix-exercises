package com.matrix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.matrix.model.Persona;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class IndexController implements Initializable {

    Alert alert = new Alert(AlertType.ERROR);
    ArrayList<Persona> persone = new ArrayList<Persona>();
    Persona personaClicked = null; 
    
    @FXML
    private ImageView close;

    @FXML
    private Button confirm;

    @FXML
    private Label labelCdf;

    @FXML
    private Label labelCognome;

    @FXML
    private Label labelNome;

    @FXML
    private TextField txtCdf;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtNome;

    
    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView iconAdd;

    @FXML
    private ImageView iconRemove;

    @FXML
    private ImageView iconSettings;

    @FXML
    private TableColumn<Persona, String> tableCdf;

    @FXML
    private TableColumn<Persona, String> tableName;

    @FXML
    private TableColumn<Persona, String> tableSurname;

    @FXML
    private TableView<Persona> tableView;

    @FXML
    void handleAdd(MouseEvent event) {
        System.out.println("CLICCATO!");
        
        pane.setVisible(true);

        txtNome.setText("");
        txtCognome.setText("");
        txtCdf.setText("");

        confirm.setOnMouseClicked((MouseEvent confirmEvent) -> handleConfirmAdd(confirmEvent));
    }

    void handleConfirmAdd(MouseEvent event) {
        Persona persona = new Persona(txtNome.getText(), txtCognome.getText(), txtCdf.getText());
        if(isError()) return;
        persone.add(persona);
        refreshTable(persone);
        pane.setVisible(false);
    }

    boolean isAlreadyUseCdf() {
        boolean toReturn = false;

        for(Persona persona : persone) {
           if(persona.getCodiceFiscale().equalsIgnoreCase(txtCdf.getText())) {
               toReturn = true;
               break;
           } 
        }
        return toReturn;
    }

    boolean isError() {
        alert.setTitle("Errore");
        alert.setHeaderText("Messaggio di errore:");

        if(formNotComplete()) {
            alert.setContentText("Uno o più campi non sono compilati.");
            alert.show();
            return true;
        }

        if(isAlreadyUseCdf()) {
            alert.setContentText("Già esiste questa persona nella lista.");
            alert.show();
            return true;
        }

        return false;
    }

    boolean formNotComplete() {
        return txtBlank(txtCdf) || txtBlank(txtNome) || txtBlank(txtCognome);
    }

    boolean txtBlank(TextField textField) {
        return (textField.getText().isEmpty() || textField.getText().equalsIgnoreCase(""));
    }

    @FXML
    void handleRemove(MouseEvent event) {
        System.out.println("Hello World");
        if(personaClicked != null){
            persone.remove(personaClicked);
            tableView.getItems().remove(personaClicked);
            personaClicked = null;
        }
    }

    @FXML
    void sendPane(MouseEvent event) {

    }

    @FXML
    void closePane(MouseEvent event) {
        pane.setVisible(false);
    }

    @FXML
    void handleSearch(KeyEvent event) {
        TextField textField = (TextField) event.getSource();

        if(textField.getText().isEmpty() || textField.getText() == "") {
            refreshTable(persone);
            return;
        }

        ArrayList<Persona> searched = new ArrayList<Persona>();

        persone.forEach((value) -> {
            if(value.getCodiceFiscale().contains(textField.getText())) {
                searched.add(value);
            }
        });
        refreshTable(searched);
    }

    @FXML
    void handleSettings(MouseEvent event) throws IOException {
      pane.setVisible(true);
      refreshPaneSettings();
      int index = persone.indexOf(personaClicked);
      confirm.setOnMouseClicked((MouseEvent confirmEvent) -> handleConfirmMod(confirmEvent, index));
    }

    void handleConfirmMod(MouseEvent event, int index) {
        if(isError()) return;

        personaClicked.setCodiceFiscale(txtCdf.getText());
        personaClicked.setNome(txtNome.getText());
        personaClicked.setCognome(txtCognome.getText());


        persone.get(index).setCodiceFiscale(txtCdf.getText());
        persone.get(index).setNome(txtNome.getText());
        persone.get(index).setCognome(txtCognome.getText());

        refreshTable(persone);
        pane.setVisible(false);
    }

    private void refreshPaneSettings() {
        txtNome.setText(personaClicked.getNome());
        txtCognome.setText(personaClicked.getCognome());
        txtCdf.setText(personaClicked.getCodiceFiscale());
    }
    
    private void refreshTable(ArrayList<Persona> list) {
        tableView.getItems().clear();
        tableView.getItems().addAll(list);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tableName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableSurname.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        tableCdf.setCellValueFactory(new PropertyValueFactory<>("codiceFiscale"));

        for(int i = 0; i < 3; i++) {
            persone.add(new Persona("test"+i, "test"+i, ""+i));
        }

        tableView.getItems().addAll(persone);

        tableView.setOnMouseClicked((MouseEvent event) -> initialiseTableView(event));
    }

    void initialiseTableView(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            personaClicked = tableView.getSelectionModel().getSelectedItem();
            if(pane.isVisible())
                refreshPaneSettings();
            iconRemove.setVisible(true);
            iconSettings.setVisible(true);
        }
    }

}
