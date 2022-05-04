package FacultyCompany.Actions;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoDialog {
    public InfoDialog(Stage primaryStage, String groupname, String subjectname,
                      Integer semesterid, Integer weekday, String lessonTime, String lecturerFullName){
        StackPane secondaryLayout = new StackPane();

        final VBox vbox = new VBox();

        vbox.setSpacing(5);

        Label groupLabel = new Label("Group name: " + groupname);
        Label subjectLabel = new Label("Subject name: " + subjectname);
        Label semestrLabel = new Label("Semester id: " + semesterid);
        Label weekLabel = new Label("Week day: " + weekday);
        Label lessonLabel = new Label("Lesson time: " + lessonTime);
        Label lecturerNameLabel = new Label("Lecturer name: " + lecturerFullName);

        vbox.getChildren().addAll(groupLabel, subjectLabel, semestrLabel, weekLabel, lessonLabel, lecturerNameLabel);
        secondaryLayout.getChildren().addAll(vbox);

        Scene secondScene = new Scene(secondaryLayout, 250, 150);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Information");
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);

        newWindow.setHeight(200);
        newWindow.setWidth(300);

        newWindow.setResizable(false);

        newWindow.show();
    }
}