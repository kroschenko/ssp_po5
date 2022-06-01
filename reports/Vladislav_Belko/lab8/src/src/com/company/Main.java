package com.company;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
public class Main extends Application {
    private Button stopThread;
    private Button resumeThread;
    private Button interruptThread;
    private Button calculate;
    private HBox threadControls;
    private HBox calculationControls;
    private TextField serialNumberInput;

    private Scene scene;
    private FlowPane root;
    private Label calculationOutput;
    private MultiThread thread;
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        thread = new MultiThread();
        root = createRoot();
        scene = new Scene(root);
        setStage(stage);
        stage.show();
    }
    private FlowPane createRoot() {
        calculationControls = createCalculationControl();
        threadControls = createControls();
        FlowPane result = new FlowPane(calculationControls, threadControls);
        result.setAlignment(Pos.CENTER);
        result.setOrientation(Orientation.HORIZONTAL);
        result.setVgap(10);
        result.setHgap(10);
        return result;
    }
    private void setStage(Stage stage) {
        stage.setTitle("Lab1_6sem");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setMinHeight(200);
        stage.setMinWidth(600);
        stage.setMaxHeight(200);
        stage.setMaxWidth(600);
    }
    private HBox createControls() {
        stopThread = new Button("Stopping");
        stopThread.setDisable(true);
        stopThread.setPrefWidth(100);
        stopThread.setOnAction(event -> {
            thread.stop();
            stopThread.setDisable(true);
            resumeThread.setDisable(false);
        });

        resumeThread = new Button("Resuming");
        resumeThread.setDisable(true);
        resumeThread.setPrefWidth(100);
        resumeThread.setOnAction(event -> {
            thread.resume();
            stopThread.setDisable(false);
            resumeThread.setDisable(true);
        });
        interruptThread = new Button("Canceling");
        interruptThread.setDisable(true);
        interruptThread.setPrefWidth(100);
        interruptThread.setOnAction(event -> {
            thread.interrupt();
            calculate.setDisable(false);
            interruptThread.setDisable(true);
            stopThread.setDisable(true);
            resumeThread.setDisable(true);
        });
        return new HBox(5, stopThread, resumeThread, interruptThread);
    }
    private HBox createCalculationControl() {
        serialNumberInput = new TextField();
        serialNumberInput.setPrefColumnCount(10);
        calculationOutput = new Label();
        calculate = new Button("Result");
        calculate.setPrefWidth(60);
        calculate.setOnAction(event -> {
            try {
                int number = Integer.parseInt(serialNumberInput.getText());
                CalculRow seriesCalculator = new CalculRow(number);
                thread.setCalculator(seriesCalculator);
                calculationOutput.textProperty().bind(seriesCalculator.messageProperty());
                thread.start();
                calculate.setDisable(true);
                stopThread.setDisable(false);
                resumeThread.setDisable(true);
                interruptThread.setDisable(false);
            }
            catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        });
        return new HBox(5, serialNumberInput, calculate, calculationOutput);
    }
}