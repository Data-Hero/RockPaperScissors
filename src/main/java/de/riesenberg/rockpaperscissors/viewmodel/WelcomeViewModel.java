package de.riesenberg.rockpaperscissors.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class WelcomeViewModel {

    private StringProperty welcomeLabel = new SimpleStringProperty();

    public WelcomeViewModel() {
        this.setWelcomeLabel("Willkommen bei Scheere Stein Papier");
    }

    public String getWelcomeLabel() {
        return welcomeLabel.get();
    }

    public StringProperty welcomeLabelProperty() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(String welcomeLabel) {
        this.welcomeLabel.set(welcomeLabel);
    }
}
