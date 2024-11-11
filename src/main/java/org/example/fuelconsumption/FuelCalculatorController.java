package org.example.fuelconsumption;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FuelCalculatorController {
    @FXML
    private TextField distanceField;
    @FXML
    private TextField fuelField;
    @FXML
    private Label resultLabel;
    @FXML
    private ChoiceBox<String> languageChoiceBox;
    @FXML
    private Label fuelLabel;
    @FXML
    private Label distanceLabel;

    private ResourceBundle bundle;
    private NumberFormat numberFormat;

    @FXML
    public void initialize() {
        languageChoiceBox.getItems().addAll("English", "French", "Japanese", "Persian");
        languageChoiceBox.setValue("English");
        languageChoiceBox.setOnAction(event -> onLanguageChange());

        loadLanguage("en", "US");
    }

    private void loadLanguage(String language, String country) {
        Locale.setDefault(new Locale(language, country));
        bundle = ResourceBundle.getBundle("messages");
        numberFormat = NumberFormat.getInstance(Locale.getDefault());
        updateLabels();
    }

    private void updateLabels() {
        distanceField.setPromptText(bundle.getString("distance.label"));
        fuelField.setPromptText(bundle.getString("fuel.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        distanceLabel.setText(bundle.getString("distance.label"));
        resultLabel.setText("");
    }

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double distance = numberFormat.parse(distanceField.getText()).doubleValue();
            double fuel = numberFormat.parse(fuelField.getText()).doubleValue();
            double consumption = (fuel / distance) * 100;
            double price = consumption * 1.67;
            resultLabel.setText(String.format(bundle.getString("result.label"), consumption, price));
        } catch (ParseException e) {
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    protected void onLanguageChange() {
        String selectedLanguage = languageChoiceBox.getValue();
        switch (selectedLanguage) {
            case "French":
                loadLanguage("fr", "FR");
                break;
            case "Japanese":
                loadLanguage("ja", "JP");
                break;
            case "Persian":
                loadLanguage("fa", "IR");
                break;
            default:
                loadLanguage("en", "US");
                break;
        }
    }
}