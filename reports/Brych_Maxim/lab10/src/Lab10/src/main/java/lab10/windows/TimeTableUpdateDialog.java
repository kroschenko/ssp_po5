package lab10.windows;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import lab10.core.RepositoryManager;
import lab10.entities.*;
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

public class TimeTableUpdateDialog {
    Label tittleLabel;
    Button addButton;

    Label weekDayLabel;
    TextField weekDayField;

    ComboBox<Subject> subjectComboBox;
    ComboBox<Group> groupComboBox;
    ComboBox<Lecturer> lecturerComboBox;
    ComboBox<Calendar> calendarComboBox;

    public TimeTableUpdateDialog(Stage primaryStage, TimeTable table) {
        initControls();

        List<Subject> subjects;
        List<Group> groups;
        List<Lecturer> lecturers;
        List<Calendar> calendars;

        try {
            RepositoryManager repositoryManager = new RepositoryManager();

            subjects = repositoryManager.subjectRepository.GetAll();
            groups = repositoryManager.groupRepository.GetAll();
            lecturers = repositoryManager.lecturerRepository.GetAll();
            calendars = repositoryManager.calendarRepository.GetAll();

            var subjectObservableList = FXCollections.observableArrayList(subjects);
            var groupObservableList = FXCollections.observableArrayList(groups);
            var lecturerObservableList = FXCollections.observableArrayList(lecturers);
            var calendarObservableList = FXCollections.observableArrayList(calendars);

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

        final HBox weekDayBox = new HBox();
        weekDayBox.setSpacing(5);
        weekDayBox.setPadding(new Insets(10, 10, 10, 10));
        weekDayBox.getChildren().addAll(weekDayLabel, weekDayField);
        final HBox subjectBox = new HBox();
        subjectBox.setSpacing(5);
        subjectBox.setPadding(new Insets(10, 10, 10, 10));
        subjectBox.getChildren().addAll(new Label("Введите subject"), subjectComboBox);
        final HBox groupBox = new HBox();
        groupBox.setSpacing(5);
        groupBox.setPadding(new Insets(10, 10, 10, 10));
        groupBox.getChildren().addAll(new Label("Введите group"), groupComboBox);
        final HBox lecturerBox = new HBox();
        lecturerBox.setSpacing(5);
        lecturerBox.setPadding(new Insets(10, 10, 10, 10));
        lecturerBox.getChildren().addAll(new Label("Введите lecturer"), lecturerComboBox);
        final HBox lessonBox = new HBox();
        lessonBox.setSpacing(5);
        lessonBox.setPadding(new Insets(10, 10, 10, 10));
        lessonBox.getChildren().addAll(new Label("Введите lesson"), calendarComboBox);
        vbox.getChildren().addAll(tittleLabel, weekDayBox,
                subjectBox,
                groupBox,
                lecturerBox,
                lessonBox, addButton);
        secondaryLayout.getChildren().addAll(vbox);

        Scene secondScene = new Scene(secondaryLayout, 300, 240);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Обновить элемент");
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 200);

        newWindow.setHeight(355);
        newWindow.setWidth(300);
        newWindow.setResizable(false);

        newWindow.show();

        addButton.setOnAction(event -> {
            int id = table.getId();

            int weekDay = Integer.parseInt(weekDayField.getText());
            int subjectId = subjectComboBox.getSelectionModel().getSelectedItem().getId();
            int groupId = groupComboBox.getSelectionModel().getSelectedItem().getId();
            int lecturerId = lecturerComboBox.getSelectionModel().getSelectedItem().getId();
            int calendarId = calendarComboBox.getSelectionModel().getSelectedItem().getId();

            if (weekDay > 7 || weekDay < 0)
                return;

            try {
                RepositoryManager  repositoryManager = new RepositoryManager();
                repositoryManager.timeTableRepository.Update(new TimeTable(id, groupId,
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
        tittleLabel = new Label("Введите информацию:");

        weekDayLabel = new Label("День недели");
        weekDayField = new TextField();

        addButton = new Button("Обновить");

        weekDayField.setMaxSize(50, 50);
    }
}
