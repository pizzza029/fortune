package com.example.fortuneteller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class HelloController {

    private final fortune_teller_class fortuneLogic = new fortune_teller_class();
    private final ObservableList<String> fortuneList = FXCollections.observableArrayList();

    // UI Components
    @FXML private Label fortuneLabel;
    @FXML private TextField newFortuneField;
    @FXML private ListView<String> fortuneListView;

    // Primary functionality
    @FXML
    protected void onGenerateFortuneClick() {
        fortuneLabel.setText(fortuneLogic.getRandomFortune());
    }

    @FXML
    protected void onAddFortuneClick() {
        String newFortune = newFortuneField.getText().trim();
        if (newFortune.isEmpty()) {//this is where I have my exception handling for adding a new Fortune
            showAlert("Input Required", "Please enter a fortune message");
            return;
        }
        fortuneLogic.addFortune(newFortune);
        newFortuneField.clear();
        updateFortuneList();
    }

    @FXML
    protected void onRemoveFortuneClick() {
        int selectedIndex = fortuneListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            fortuneLogic.removeFortune(selectedIndex);
            updateFortuneList();
        } else {// this is where i have my exception handling for removing  a  Fortune
            showAlert("Selection Required", "Please select a fortune to remove");
        }
    }

    // this is for initialize the  updates
    @FXML
    public void initialize() {
        updateFortuneList();
    }

    private void updateFortuneList() {
        fortuneList.setAll(fortuneLogic.getAllFortunes());
        fortuneListView.setItems(fortuneList);
    }

    // the popup windos
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}