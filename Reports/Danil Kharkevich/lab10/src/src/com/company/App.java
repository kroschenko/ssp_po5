package com.company;

import com.company.actions.InfoDialog;
import com.company.actions.TimeTableAddingDialog;
import com.company.actions.TimeTableUpdatingDialog;
import com.company.database.DBManager;
import com.company.entities.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class App extends Application {
    public static DBManager dbManager;
    
    public App() throws SQLException {
        dbManager = new DBManager();
    }
    
    TableView<TimeTableClass> timeTableClass;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<TimeTable> scheduleTables = dbManager.scheduleTable.GetAll();
        
        ArrayList<TimeTable> scheduleTablesWithData = convertWithData(scheduleTables);
        
        ArrayList<TimeTableClass> VmTimeTable = new ArrayList<>();
        
        scheduleTablesWithData.forEach(t -> {
            VmTimeTable.add(new TimeTableClass(t));
        });

        ObservableList<TimeTableClass> observableTimeTables = FXCollections.observableArrayList(VmTimeTable);

        timeTableClass = new TableView<>(observableTimeTables);

        timeTableClass.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        timeTableClass.setPrefSize(720,200);

        TableColumn<TimeTableClass, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeTableClass.getColumns().add(idColumn);

        TableColumn<TimeTableClass, String> groupnameColumn = new TableColumn<>("Group Name");
        groupnameColumn.setCellValueFactory(new PropertyValueFactory<>("groupname"));
        timeTableClass.getColumns().add(groupnameColumn);

        TableColumn<TimeTableClass, String> subjectNameColumn = new TableColumn<>("Subject Name");
        subjectNameColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        timeTableClass.getColumns().add(subjectNameColumn);

        TableColumn<TimeTableClass, Integer> semesteridColumn = new TableColumn<>("Semestre Id");
        semesteridColumn.setCellValueFactory(new PropertyValueFactory<>("semesterid"));
        timeTableClass.getColumns().add(semesteridColumn);

        TableColumn<TimeTableClass, Integer> weekdayColumn = new TableColumn<>("Week Day");
        weekdayColumn.setCellValueFactory(new PropertyValueFactory<>("weekday"));
        timeTableClass.getColumns().add(weekdayColumn);

        TableColumn<TimeTableClass, String> lessontimeColumn = new TableColumn<>("Lesson Time");
        lessontimeColumn.setCellValueFactory(new PropertyValueFactory<>("lessontime"));
        timeTableClass.getColumns().add(lessontimeColumn);

        executeRefresh();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(new Label("TimeTable"), timeTableClass);

        Button addCellButton = new Button();
        addCellButton.setText("Add a new cell");

        addCellButton.setOnAction(event -> {
           new TimeTableAddingDialog(primaryStage);
        });

        vbox.getChildren().addAll(addCellButton);


        Button infoButton = new Button();
        infoButton.setText("Cell's details");

        infoButton.setOnAction(event -> {
            TimeTableClass infoTimeTable = timeTableClass.getSelectionModel().getSelectedItems().get(0);
            new InfoDialog(primaryStage, infoTimeTable.getGroupname(), infoTimeTable.getSubjectName(), infoTimeTable.getSemesterid(),
                    infoTimeTable.getWeekday(), infoTimeTable.getLessontime(), infoTimeTable.getLecturerFullName());
        });

        vbox.getChildren().addAll(infoButton);


        Button updateButton = new Button();
        updateButton.setText("Update cell");

        updateButton.setOnAction(event -> {
            TimeTableClass updateTimeTable = timeTableClass.getSelectionModel().getSelectedItems().get(0);
            TimeTable vmtable = new TimeTable();

            try {
                vmtable = dbManager.scheduleTable.GetByIdOrNull(updateTimeTable.getId());
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            new TimeTableUpdatingDialog(primaryStage, vmtable);
        });

        vbox.getChildren().addAll(updateButton);


        Button deleteCellButton = new Button();
        deleteCellButton.setText("Delete cell");

        deleteCellButton.setOnAction(event -> {
            try {
                executeDelete();
                executeRefresh();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        vbox.getChildren().addAll(deleteCellButton);


        Button refreshCellButton = new Button();
        refreshCellButton.setText("Refresh table");

        refreshCellButton.setOnAction(event -> {
            try {
                executeRefresh();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        vbox.getChildren().addAll(refreshCellButton);


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TimeTable");

        Scene scene = new Scene(root, 500, 500);
        ((GridPane) scene.getRoot()).getChildren().addAll(vbox);
        primaryStage.setScene(scene);

        primaryStage.setHeight(425);
        primaryStage.setWidth(550);

        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void executeRefresh() throws SQLException {
        timeTableClass.getItems().clear();

        ArrayList timeTables = dbManager.scheduleTable.GetAll();

        ArrayList timeTablesWithData = convertWithData(timeTables);
        ArrayList<TimeTableClass> VmTimeTable = new ArrayList<>();

        timeTablesWithData.forEach(t -> {
            VmTimeTable.add(new TimeTableClass((TimeTable) t));
        });

        ObservableList<TimeTableClass> observableTimeTables = (ObservableList<TimeTableClass>) FXCollections.observableArrayList(VmTimeTable);

        timeTableClass.getItems().addAll(observableTimeTables);
    }

    private void executeDelete() throws SQLException {
        TimeTableClass deletedTimeTable = timeTableClass.getSelectionModel().getSelectedItems().get(0);
        dbManager.scheduleTable.Delete(new TimeTable(deletedTimeTable.getId()));
    }

    public static ArrayList<TimeTable> convertWithData(ArrayList<TimeTable> table) {
        table.forEach(t -> {
            try {
                t.setGroup(DBManager.groupTable.GetByIdOrNull(t.getGroupid()));
                t.setSubject(DBManager.subjectTable.GetByIdOrNull(t.getSubjectid()));
                t.setLecturer(DBManager.lecturerTable.GetByIdOrNull(t.getLecturerid()));
                t.setCalendar(DBManager.calendarTable.GetByIdOrNull(t.getLessonid()));
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        return table;
    }
}
