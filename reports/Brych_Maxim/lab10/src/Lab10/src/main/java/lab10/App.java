package lab10;

import javafx.scene.layout.HBox;
import lab10.windows.InfoDialog;
import lab10.windows.TimeTableAddDialog;
import lab10.windows.TimeTableUpdateDialog;
import lab10.core.RepositoryManager;
import lab10.entities.*;
import lab10.viewModels.TimeTableViewModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

import java.util.ArrayList;

public class App extends Application {
    private static RepositoryManager repositoryManager;

    public App() throws SQLException {
        repositoryManager = new RepositoryManager();
    }

    TableView<TimeTableViewModel> tableTimeTables;

    @Override
    public void start(Stage primaryStage) throws Exception {
        var timeTables= repositoryManager.timeTableRepository.GetAll();

        var timeTablesWithData = convertWithData(timeTables);

        ArrayList<TimeTableViewModel> VmTimeTable = new ArrayList<>();

        timeTablesWithData.forEach(t -> VmTimeTable.add(new TimeTableViewModel(t)));

        var observableTimeTables = FXCollections.observableArrayList(VmTimeTable);

        tableTimeTables = new TableView<>(observableTimeTables);

        tableTimeTables.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableTimeTables.setPrefSize(720,200);

        TableColumn<TimeTableViewModel, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableTimeTables.getColumns().add(idColumn);

        TableColumn<TimeTableViewModel, String> groupnameColumn = new TableColumn<>("Group Name");
        groupnameColumn.setCellValueFactory(new PropertyValueFactory<>("groupname"));
        tableTimeTables.getColumns().add(groupnameColumn);

        TableColumn<TimeTableViewModel, String> subjectNameColumn = new TableColumn<>("Subject Name");
        subjectNameColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        tableTimeTables.getColumns().add(subjectNameColumn);

        TableColumn<TimeTableViewModel, Integer> semesteridColumn = new TableColumn<>("Semestre Id");
        semesteridColumn.setCellValueFactory(new PropertyValueFactory<>("semesterid"));
        tableTimeTables.getColumns().add(semesteridColumn);

        TableColumn<TimeTableViewModel, Integer> weekdayColumn = new TableColumn<>("Week Day");
        weekdayColumn.setCellValueFactory(new PropertyValueFactory<>("weekday"));
        tableTimeTables.getColumns().add(weekdayColumn);

        TableColumn<TimeTableViewModel, String> lessontimeColumn = new TableColumn<>("Lesson Time");
        lessontimeColumn.setCellValueFactory(new PropertyValueFactory<>("lessontime"));
        tableTimeTables.getColumns().add(lessontimeColumn);

        executeRefresh();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(new Label("Расписание"), tableTimeTables);
        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        Button addCellButton = new Button();
        addCellButton.setText("Добавить");

        addCellButton.setOnAction(event -> new TimeTableAddDialog(primaryStage));

        hbox.getChildren().addAll(addCellButton);

        Button infoButton = new Button();
        infoButton.setText("Детально");

        infoButton.setOnAction(event -> {
            TimeTableViewModel infoTimeTable = tableTimeTables.getSelectionModel().getSelectedItems().get(0);
            new InfoDialog(primaryStage, infoTimeTable.getGroupname(), infoTimeTable.getSubjectName(), infoTimeTable.getSemesterid(),
                    infoTimeTable.getWeekday(), infoTimeTable.getLessontime(), infoTimeTable.getLecturerFullName());
        });

        hbox.getChildren().addAll(infoButton);

        Button updateButton = new Button();
        updateButton.setText("Изменить");

        updateButton.setOnAction(event -> {
            TimeTableViewModel updateTimeTable = tableTimeTables.getSelectionModel().getSelectedItems().get(0);
            TimeTable vmtable = new TimeTable();

            try {
                vmtable = repositoryManager.timeTableRepository.GetByIdOrNull(updateTimeTable.getId());
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            new TimeTableUpdateDialog(primaryStage, vmtable);
        });

        hbox.getChildren().addAll(updateButton);

        Button deleteCellButton = new Button();
        deleteCellButton.setText("Удалить");

        deleteCellButton.setOnAction(event -> {
            try {
                executeDelete();
                executeRefresh();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        hbox.getChildren().addAll(deleteCellButton);

        Button refreshCellButton = new Button();
        refreshCellButton.setText("Обновить таблицу");

        refreshCellButton.setOnAction(event -> {
            try {
                executeRefresh();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        hbox.getChildren().addAll(refreshCellButton);
        vbox.getChildren().addAll(hbox);
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Lab10");

        Scene scene = new Scene(root, 500, 500);
        ((GridPane) scene.getRoot()).getChildren().addAll(vbox);
        primaryStage.setScene(scene);

        primaryStage.setHeight(380);
        primaryStage.setWidth(600);

        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void executeRefresh() throws SQLException {
        tableTimeTables.getItems().clear();

        var timeTables= repositoryManager.timeTableRepository.GetAll();

        var timeTablesWithData = convertWithData(timeTables);
        ArrayList<TimeTableViewModel> VmTimeTable = new ArrayList<>();

        timeTablesWithData.forEach(t -> VmTimeTable.add(new TimeTableViewModel(t)));

        var observableTimeTables = FXCollections.observableArrayList(VmTimeTable);

        tableTimeTables.getItems().addAll(observableTimeTables);
    }

    private void executeDelete() throws SQLException {
        TimeTableViewModel deletedTimeTable = tableTimeTables.getSelectionModel().getSelectedItems().get(0);
        repositoryManager.timeTableRepository.Delete(new TimeTable(deletedTimeTable.getId()));
    }

    public static ArrayList<TimeTable> convertWithData(ArrayList<TimeTable> table) {
        table.forEach(t -> {
            try {
                t.setGroup(repositoryManager.groupRepository.GetByIdOrNull(t.getGroupid()));
                t.setSubject(repositoryManager.subjectRepository.GetByIdOrNull(t.getSubjectid()));
                t.setLecturer(repositoryManager.lecturerRepository.GetByIdOrNull(t.getLecturerid()));
                t.setCalendar(repositoryManager.calendarRepository.GetByIdOrNull(t.getLessonid()));
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        return table;
    }
}
