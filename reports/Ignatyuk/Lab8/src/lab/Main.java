package lab;

import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.stage.Stage;

public final class Main extends Application {
    private FlowPane pane;
    private Scene scene;

    private TextField input;
    private Label output;

    private HBox threadControls;
    private HBox processControls;
    private HBox outputBox;

    private Button stopThread;
    private Button resumeThread;
    private Button interruptThread;
    private Button process;

    private Row row;
    private Handler handler;

    public final static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public final void start(final Stage stage) {
        initThreadControls();
        initProcessControls();

        this.pane = new FlowPane(this.processControls, this.threadControls, this.outputBox);
        this.pane.setAlignment(Pos.CENTER);
        this.pane.setOrientation(Orientation.HORIZONTAL);
        this.pane.setVgap(10);
        this.pane.setHgap(10);

        this.scene = new Scene(this.pane);
        this.handler = new Handler();

        stage.setTitle("lab");
        stage.setResizable(false);
        stage.setMinHeight(320);
        stage.setMinWidth(480);
        stage.setScene(scene);
        stage.show();
    }

    private final void initThreadControls() {
        this.stopThread = new Button("Stop");
        this.stopThread.setPrefWidth(100);
        this.stopThread.setDisable(true);

        this.stopThread.setOnAction(event -> {
            this.handler.stop();
            this.stopThread.setDisable(true);
            this.resumeThread.setDisable(false);
        });

        this.resumeThread = new Button("Resume");
        this.resumeThread.setPrefWidth(100);
        this.resumeThread.setDisable(true);

        this.resumeThread.setOnAction(event -> {
            this.handler.resume();
            this.stopThread.setDisable(false);
            this.resumeThread.setDisable(true);
        });

        this.interruptThread = new Button("Interrupt");
        this.interruptThread.setPrefWidth(100);
        this.interruptThread.setDisable(true);

        this.interruptThread.setOnAction(event -> {
            this.handler.interrupt();
            this.stopThread.setDisable(true);
            this.resumeThread.setDisable(true);
            this.interruptThread.setDisable(true);
            this.process.setDisable(false);
        });

        this.threadControls = new HBox(5, this.stopThread, this.resumeThread, this.interruptThread);
    }

    private final void initProcessControls() {
        this.input = new TextField();
        this.output = new Label();

        this.process = new Button("Process");
        this.process.setOnAction(event -> {
            try {
                int n = Integer.parseInt(this.input.getText());

                this.row = new Row(n);
                this.handler.setRow(this.row);
                this.output.textProperty().bind(this.row.messageProperty());
                this.handler.start();

                this.stopThread.setDisable(false);
                this.resumeThread.setDisable(true);
                this.interruptThread.setDisable(false);
                this.process.setDisable(true);
            } catch (final NumberFormatException exception) {
                System.out.println(exception.getMessage());
            }
        });

        this.processControls = new HBox(5, this.input, this.process);
        this.outputBox = new HBox(5, this.output);
    }
}
