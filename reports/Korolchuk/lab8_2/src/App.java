package hello_java.mavenproject1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application {
    static Thread thread = new Thread();
    static Equation myTask = null;
    static boolean threadInterrupted = false;
    
    static public void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(createInterface());
        Scene scene = new Scene(root, 600, 375);
        stage.setTitle("Multithreading int JavaFX");
        stage.setScene(scene);
        stage.show();
    }
    
    private GridPane createInterface() {
        GridPane gp = new GridPane();
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Button btnStart = new Button("Start");
        Button btnPause = new Button("Pause");
        Button btnContinue = new Button("Continue");
        Button btnStop = new Button("Stop");
        btnPause.setDisable(true);
        btnContinue.setDisable(true);
        btnStop.setDisable(true);
        Label lbl1 = new Label();
        Label lbl2 = new Label();
        gp.add(new Label("Enter n: "), 0, 0);
        gp.add(tf1, 1, 0);
        gp.add(new Label("Enter x: "), 0, 1);
        gp.add(tf2, 1, 1);
        gp.add(btnStart, 0, 2);
        gp.add(lbl1, 1, 2);
        gp.add(btnPause, 0, 3);
        gp.add(btnContinue, 1, 3);
        gp.add(btnStop, 0, 4);
        gp.add(new Label("Result: "), 0, 5);
        gp.add(lbl2, 1, 5);
        gp.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               int n = Integer.parseInt(tf1.getText());
               double x = Double.parseDouble(tf2.getText());
               Equation task = new Equation(n, x);
               myTask = task;
               lbl1.textProperty().bind(task.messageProperty());
               
               task.setOnRunning((succeesesEvent) -> {
                  btnStart.setDisable(true);
                  btnPause.setDisable(false);
                  btnContinue.setDisable(true);
                  btnStop.setDisable(false);
                  lbl2.setText("");
               });
               
               task.setOnSucceeded((succeededEvent) -> {
                  lbl2.setText(task.getValue().toString());
                  btnStart.setDisable(false);
                  btnPause.setDisable(true);
                  btnContinue.setDisable(true);
                  btnStop.setDisable(true);
               });
               Thread thread = new Thread(task);
               App.thread = thread;
               App.thread.start();
           }
        });
        btnPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnPause.setDisable(true);
                btnContinue.setDisable(false);
                
                App.thread.suspend();
            }
        });
        btnContinue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnPause.setDisable(false);
                btnContinue.setDisable(true);
                
                App.thread.resume();
            }
        });
        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnPause.setDisable(true);
                btnContinue.setDisable(true);
                btnStart.setDisable(false);
                
                App.thread = null;
                btnStop.setDisable(true);
                tf1.clear();
                tf2.clear();
                //lbl1.setText("Done");
            }
        });
        
        return gp;
    }
}
