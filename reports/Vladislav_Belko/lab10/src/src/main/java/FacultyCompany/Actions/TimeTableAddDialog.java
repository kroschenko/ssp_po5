package FacultyCompany.Actions;

import FacultyCompany.Core.RepositoryManager;
import FacultyCompany.Entities.*;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class TimeTableAddDialog {
    Label tittleLabel;
    Button addButton;

    Label weekDayLabel;
    TextField weekDayField;

    ComboBox<Subject> subjectComboBox;
    ComboBox<Group> groupComboBox;
    ComboBox<Teacher> teacherComboBox;
    ComboBox<Calendar> calendarComboBox;

    public TimeTableAddDialog(Stage primaryStage) {
        initControls();

        List<Subject> subjects;
        List<Group> groups;
        List<Teacher> teachers;
        List<Calendar> calendars;

        try {
            RepositoryManager repositoryManager = new RepositoryManager();

            subjects = repositoryManager.subjectRepository.GetAll();
            groups = repositoryManager.groupRepository.GetAll();
            teachers = repositoryManager.teacherRepository.GetAll();
            calendars = repositoryManager.calendarRepository.GetAll();

            var subjectObservableList = FXCollections.observableArrayList(subjects);
            var groupObservableList = FXCollections.observableArrayList(groups);
            var teacherObservableList = FXCollections.observableArrayList(teachers);
            var calendarObservableList = FXCollections.observableArrayList(calendars);

            subjectComboBox = new ComboBox<>(subjectObservableList);
            groupComboBox = new ComboBox<>(groupObservableList);
            teacherComboBox = new ComboBox<>(teacherObservableList);
            calendarComboBox = new ComboBox<>(calendarObservableList);

            subjectComboBox.setValue(subjectObservableList.get(0));
            groupComboBox.setValue(groupObservableList.get(0));
            teacherComboBox.setValue(teacherObservableList.get(0));
            calendarComboBox.setValue(calendarObservableList.get(0));
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        StackPane secondaryLayout = new StackPane();
        final VBox vbox = new VBox();

        vbox.setSpacing(5);

        vbox.getChildren().addAll(tittleLabel, weekDayLabel, weekDayField,
                new Label("Enter subject"), subjectComboBox,
                new Label("Enter group"), groupComboBox,
                new Label("Enter teacher"), teacherComboBox,
                new Label("Enter lesson"), calendarComboBox, addButton);
        secondaryLayout.getChildren().addAll(vbox);

        Scene secondScene = new Scene(secondaryLayout, 300, 240);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Add new information");
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 200);

        newWindow.setHeight(400);
        newWindow.setWidth(250);
        newWindow.setResizable(false);

        newWindow.show();

        addButton.setOnAction(event -> {
            Integer weekDay = Integer.parseInt(weekDayField.getText());

            Integer subjectId = subjectComboBox.getSelectionModel().getSelectedItem().getId();
            Integer groupId = groupComboBox.getSelectionModel().getSelectedItem().getId();
            Integer teacherId = teacherComboBox.getSelectionModel().getSelectedItem().getId();
            Integer calendarId = calendarComboBox.getSelectionModel().getSelectedItem().getId();

            if (weekDay > 7 || weekDay <= 0)
                return;

            try {
                RepositoryManager repositoryManager = new RepositoryManager();
                repositoryManager.timeTableRepository.Add(new TimeTable(groupId, subjectId, teacherId, weekDay, calendarId));
                newWindow.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public void initControls()
    {
        tittleLabel = new Label("Enter the information:");

        weekDayLabel = new Label("Week day");
        weekDayField = new TextField();

        addButton = new Button("Add the information");

        weekDayField.setMaxSize(50, 50);
    }
}