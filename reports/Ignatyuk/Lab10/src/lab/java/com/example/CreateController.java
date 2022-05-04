package com.example;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public final class CreateController implements Initializable {
    @FXML
    private ChoiceBox<String> customersChoiceBox;
    @FXML
    private ChoiceBox<String> workersChoiceBox;
    @FXML
    private ChoiceBox<String> cpuChoiceBox;
    @FXML
    private ChoiceBox<String> gpuChoiceBox;

    private DB db = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            this.db = new DB();

            ObservableList<String> customersList = FXCollections.observableArrayList();
            ObservableList<String> workersList = FXCollections.observableArrayList();
            ObservableList<String> cpuList = FXCollections.observableArrayList();
            ObservableList<String> gpuList = FXCollections.observableArrayList();

            ResultSet customersSet = this.db.getAll(DB.CUSTOMERS_TABLE);
            ResultSet workersSet = this.db.getAll(DB.WORKERS_TABLE);
            ResultSet cpuSet = this.db.getAll(DB.CPU_TABLE);
            ResultSet gpuSet = this.db.getAll(DB.GPU_TABLE);

            while (customersSet.next() && workersSet.next() && cpuSet.next() && gpuSet.next()) {
                customersList.add(customersSet.getString("email"));
                workersList.add(workersSet.getString("email"));
                cpuList.add(cpuSet.getString("name"));
                gpuList.add(gpuSet.getString("name"));
            }

            this.customersChoiceBox.setItems(customersList);
            this.workersChoiceBox.setItems(workersList);
            this.cpuChoiceBox.setItems(cpuList);
            this.gpuChoiceBox.setItems(gpuList);
        } catch (final SQLException exception) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void create() {
        if (this.customersChoiceBox.getSelectionModel().isEmpty()
                || this.workersChoiceBox.getSelectionModel().isEmpty()
                || this.cpuChoiceBox.getSelectionModel().isEmpty()
                || this.gpuChoiceBox.getSelectionModel().isEmpty()) {
            return;
        }

        this.db.addOrder(new Order(null,
                this.customersChoiceBox.getValue(),
                this.workersChoiceBox.getValue(),
                null,
                0.0,
                this.cpuChoiceBox.getValue(),
                this.gpuChoiceBox.getValue()));
    }
}
