package com.company.actions;

import com.company.database.DBManager;
import com.company.entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class TimeTableUpdatingDialog {
    Label tittleLabel;
    Button addButton;

    Label weekDayLabel;
    TextField weekDayField;

    ComboBox<Subject> subjectComboBox;
    ComboBox<Group> groupComboBox;
    ComboBox<Lecturer> lecturerComboBox;
    ComboBox<Calendar> calendarComboBox;

    public TimeTableUpdatingDialog(Stage primaryStage, TimeTable table) {
        initControls();

        List<Subject> subjects;
        List<Group> groups;
        List<Lecturer> lecturers;
        List<Calendar> calendars;

        try {
            DBManager dbManager = new DBManager();

            subjects = dbManager.subjectTable.GetAll();
            groups = dbManager.groupTable.GetAll();
            lecturers = dbManager.lecturerTable.GetAll();
            calendars = dbManager.calendarTable.GetAll();

            ObservableList<Subject> subjectObservableList = FXCollections.observableArrayList(subjects);
            ObservableList<Group> groupObservableList = FXCollections.observableArrayList(groups);
            ObservableList<Lecturer> lecturerObservableList = FXCollections.observableArrayList(lecturers);
            ObservableList<Calendar> calendarObservableList = FXCollections.observableArrayList(calendars);

            subjectComboBox = new ComboBox<>(subjectObservableList);
            groupComboBox = new ComboBox<>(groupObservableList);
            lecturerComboBox = new ComboBox<>(lecturerObservableList);
            calendarComboBox = new ComboBox<>(calendarObservableList);

            subjectComboBox.setValue(subjectObservableList.get(table.getSubjectid() - 1));
            groupComboBox.setValue(groupObservableList.get(table.getGroupid() - 1));
            lecturerComboBox.setValue(lecturerObservableList.get(table.getLecturerid()));
            calendarComboBox.setValue(calendarObservableList.get(table.getLessonid() - 1));

            String text = Integer.toString(table.getWeekday()) ;
            weekDayField.setText(text);
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
                new Label("Enter lecturer"), lecturerComboBox,
                new Label("Enter lesson"), calendarComboBox, addButton);
        secondaryLayout.getChildren().addAll(vbox);

        Scene secondScene = new Scene(secondaryLayout, 300, 240);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Update cell");
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
            Integer id = table.getId();

            Integer weekDay = Integer.parseInt(weekDayField.getText());
            Integer subjectId = subjectComboBox.getSelectionModel().getSelectedItem().getId();
            Integer groupId = groupComboBox.getSelectionModel().getSelectedItem().getId();
            Integer lecturerId = lecturerComboBox.getSelectionModel().getSelectedItem().getId();
            Integer calendarId = calendarComboBox.getSelectionModel().getSelectedItem().getId();

            if (weekDay > 7 || weekDay < 0)
                return;

            try {
                DBManager  dbManager = new DBManager();
                dbManager.scheduleTable.Update(new TimeTable(id, groupId,
                        subjectId, lecturerId, weekDay, calendarId));
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

        addButton = new Button("Update cell");

        weekDayField.setMaxSize(50, 50);
    }
}
