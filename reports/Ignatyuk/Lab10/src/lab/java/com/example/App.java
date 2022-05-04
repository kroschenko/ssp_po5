package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public final class App extends Application {
    private static Scene scene;

    @Override
    public final void start(final Stage stage) throws IOException {
        App.scene = new Scene(App.loadFXML("main"), 640, 480);
        stage.setResizable(false);
        stage.setScene(App.scene);
        stage.show();
    }

    public final static Parent loadFXML(final String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public final static void main(final String[] args) {
        launch();
    }
}
