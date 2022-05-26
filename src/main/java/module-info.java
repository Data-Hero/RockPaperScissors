module de.riesenberg.rockpaperscissors {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires unirest.java;
    requires com.google.gson;

    opens de.riesenberg.rockpaperscissors to javafx.fxml;
    exports de.riesenberg.rockpaperscissors;
    exports de.riesenberg.rockpaperscissors.model;
    opens de.riesenberg.rockpaperscissors.model to javafx.fxml, com.google.gson;
    exports de.riesenberg.rockpaperscissors.viewmodel;
    opens de.riesenberg.rockpaperscissors.viewmodel to javafx.fxml;
    exports de.riesenberg.rockpaperscissors.view;
    opens de.riesenberg.rockpaperscissors.view to javafx.fxml;
    exports de.riesenberg.rockpaperscissors.util;
    opens de.riesenberg.rockpaperscissors.util to javafx.fxml;

}