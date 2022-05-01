package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public final class MainController implements Initializable {
    @FXML
    private TableView<Order> ordersTableView;
    @FXML
    private TableColumn<Order, String> ordersTableViewId;
    @FXML
    private TableColumn<Order, String> ordersTableViewCustomer;
    @FXML
    private TableColumn<Order, String> ordersTableViewWorker;
    @FXML
    private TableColumn<Order, Date> ordersTableViewDate;
    @FXML
    private TableColumn<Order, Double> ordersTableViewPrice;
    @FXML
    private TableColumn<Order, String> ordersTableViewCpu;
    @FXML
    private TableColumn<Order, String> ordersTableViewGpu;
    @FXML
    private TableColumn<Order, String> ordersTableViewEdit;

    @FXML
    private TextField customerFirstNameTextField;
    @FXML
    private TextField customerLastNameTextField;
    @FXML
    private TextField workerFirstNameTextField;
    @FXML
    private TextField workerLastNameTextField;
    @FXML
    private TextField workerPositionTextField;
    @FXML
    private TextField cpuPriceTextField;
    @FXML
    private TextArea cpuDescriptionTextArea;
    @FXML
    private TextField gpuPriceTextField;
    @FXML
    private TextArea gpuDescriptionTextArea;

    @FXML
    private ChoiceBox<String> customersChoiceBox;
    @FXML
    private ChoiceBox<String> workersChoiceBox;

    private ObservableList<Order> ordersList = null;
    private DB db = null;

    String customerFilter = null;
    String workerFilter = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.ordersList = FXCollections.observableArrayList();
        this.db = new DB();

        this.ordersTableViewId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.ordersTableViewCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        this.ordersTableViewWorker.setCellValueFactory(new PropertyValueFactory<>("worker"));
        this.ordersTableViewDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.ordersTableViewPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        this.ordersTableViewCpu.setCellValueFactory(new PropertyValueFactory<>("cpu"));
        this.ordersTableViewGpu.setCellValueFactory(new PropertyValueFactory<>("gpu"));

        ChangeListener<Object> listener = (obs, oldValue, newValue) -> {
            try {
                Order order = this.ordersTableView.getSelectionModel().getSelectedItem();

                if (order == null) {
                    return;
                }

                ResultSet orderDetailsSet = this.db.getOrderDetails(order.getId());
                orderDetailsSet.next();

                this.customerFirstNameTextField.setText(orderDetailsSet.getString("customer_first_name"));
                this.customerLastNameTextField.setText(orderDetailsSet.getString("customer_last_name"));
                this.workerFirstNameTextField.setText(orderDetailsSet.getString("worker_first_name"));
                this.workerLastNameTextField.setText(orderDetailsSet.getString("worker_last_name"));
                this.workerPositionTextField.setText(orderDetailsSet.getString("worker_position"));
                this.cpuPriceTextField.setText(Double.toString(orderDetailsSet.getDouble("cpu_price")));
                this.cpuDescriptionTextArea.setText(orderDetailsSet.getString("cpu_description"));
                this.gpuPriceTextField.setText(Double.toString(orderDetailsSet.getDouble("gpu_price")));
                this.gpuDescriptionTextArea.setText(orderDetailsSet.getString("gpu_description"));
            } catch (final SQLException exception) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
            } catch (final Exception exception) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
            }
        };

        this.ordersTableView.focusedProperty().addListener(listener);
        this.ordersTableView.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    @FXML
    private final void create() {
        try {
            Parent parent = App.loadFXML("create");
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (final IOException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void read() {
        try {
            this.clearTextFields();
            this.ordersList.clear();

            ResultSet ordersSet = this.db.getOrders(this.customerFilter, this.workerFilter, null);

            while (ordersSet.next()) {
                this.ordersList.add(new Order(
                        ordersSet.getInt("id"),
                        ordersSet.getString("customer"),
                        ordersSet.getString("worker"),
                        ordersSet.getDate("date"),
                        ordersSet.getDouble("price"),
                        ordersSet.getString("cpu"),
                        ordersSet.getString("gpu")));
                this.ordersTableView.setItems(this.ordersList);
            }

            ObservableList<String> customersList = FXCollections.observableArrayList();
            ObservableList<String> workersList = FXCollections.observableArrayList();

            ResultSet customersSet = this.db.getAll(DB.CUSTOMERS_TABLE);
            ResultSet workersSet = this.db.getAll(DB.WORKERS_TABLE);

            while (customersSet.next() && workersSet.next()) {
                customersList.add(customersSet.getString("email"));
                workersList.add(workersSet.getString("email"));
            }

            this.customersChoiceBox.setItems(customersList);
            this.workersChoiceBox.setItems(workersList);
        } catch (final SQLException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void update() {
        try {
            Order order = this.ordersTableView.getSelectionModel().getSelectedItem();

            if (order == null) {
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("update.fxml"));
            Parent parent = loader.load();

            UpdateController updateController = loader.getController();
            updateController.setUpdatingId(order.getId());

            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (final IOException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void delete() {
        Order order = this.ordersTableView.getSelectionModel().getSelectedItem();

        if (order == null) {
            return;
        }

        this.db.deleteByID(DB.ORDERS_TABLE, order.getId());
    }

    @FXML
    private final void search() {
        this.customerFilter = this.customersChoiceBox.getValue();
        this.workerFilter = this.workersChoiceBox.getValue();
        this.read();
    }

    private final void clearTextFields() {
        this.customerFirstNameTextField.clear();
        this.customerLastNameTextField.clear();
        this.workerFirstNameTextField.clear();
        this.workerLastNameTextField.clear();
        this.workerPositionTextField.clear();
        this.cpuPriceTextField.clear();
        this.cpuDescriptionTextArea.clear();
        this.gpuPriceTextField.clear();
        this.gpuDescriptionTextArea.clear();
    }
}
