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
    private TableView<Match> matchesTableView;
    @FXML
    private TableColumn<Match, String> matchesTableViewId;
    @FXML
    private TableColumn<Match, String> matchesTableViewLeague;
    @FXML
    private TableColumn<Match, String> matchesTableViewStadium;
    @FXML
    private TableColumn<Match, Date> matchesTableViewDate;
    @FXML
    private TableColumn<Match, String> matchesTableViewTeam1;
    @FXML
    private TableColumn<Match, String> matchesTableViewTeam2;
    @FXML
    private TableColumn<Match, String> matchesTableViewEdit;

    @FXML
    private TextField leagueNameTextField;
    @FXML
    private TextField leagueCountryTextField;
    @FXML
    private TextField stadiumNameTextField;
    @FXML
    private TextField stadiumCountryTextField;
    @FXML
    private TextArea team1DescriptionTextArea;
    @FXML
    private TextArea team2DescriptionTextArea;

    @FXML
    private ChoiceBox<String> leaguesChoiceBox;
    @FXML
    private ChoiceBox<String> stadiumsChoiceBox;

    private ObservableList<Match> matchesList = null;
    private DB db = null;

    String leagueFilter = null;
    String stadiumFilter = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.matchesList = FXCollections.observableArrayList();
        this.db = new DB();

        this.matchesTableViewId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.matchesTableViewLeague.setCellValueFactory(new PropertyValueFactory<>("league"));
        this.matchesTableViewStadium.setCellValueFactory(new PropertyValueFactory<>("stadium"));
        this.matchesTableViewDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.matchesTableViewTeam1.setCellValueFactory(new PropertyValueFactory<>("team1"));
        this.matchesTableViewTeam2.setCellValueFactory(new PropertyValueFactory<>("team2"));

        ChangeListener<Object> listener = (obs, oldValue, newValue) -> {
            try {
                Match match = this.matchesTableView.getSelectionModel().getSelectedItem();

                if (match == null) {
                    return;
                }

                ResultSet matchDetailsSet = this.db.getMatchDetails(match.getId());
                matchDetailsSet.next();

                this.leagueNameTextField.setText(matchDetailsSet.getString("league_name"));
                this.leagueCountryTextField.setText(matchDetailsSet.getString("league_country"));
                this.stadiumNameTextField.setText(matchDetailsSet.getString("stadium_name"));
                this.stadiumCountryTextField.setText(matchDetailsSet.getString("stadium_country"));
                this.team1DescriptionTextArea.setText(matchDetailsSet.getString("team1_description"));
                this.team2DescriptionTextArea.setText(matchDetailsSet.getString("team2_description"));
            } catch (final SQLException exception) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
            } catch (final Exception exception) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
            }
        };

        this.matchesTableView.focusedProperty().addListener(listener);
        this.matchesTableView.getSelectionModel().selectedItemProperty().addListener(listener);
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
            this.matchesList.clear();

            ResultSet matchesSet = this.db.getMatches(this.leagueFilter, this.stadiumFilter, null);

            while (matchesSet.next()) {
                this.matchesList.add(new Match(
                        matchesSet.getInt("id"),
                        matchesSet.getString("league"),
                        matchesSet.getString("stadium"),
                        matchesSet.getDate("date"),
                        matchesSet.getString("team1"),
                        matchesSet.getString("team2")));
                this.matchesTableView.setItems(this.matchesList);
            }

            ObservableList<String> leaguesList = FXCollections.observableArrayList();
            ObservableList<String> stadiumsList = FXCollections.observableArrayList();

            ResultSet leaguesSet = this.db.getAll(DB.LEAGUES_TABLE);
            ResultSet stadiumsSet = this.db.getAll(DB.STADIUMS_TABLE);

            while (leaguesSet.next() && stadiumsSet.next()) {
                leaguesList.add(leaguesSet.getString("short_name"));
                stadiumsList.add(stadiumsSet.getString("short_name"));
            }

            this.leaguesChoiceBox.setItems(leaguesList);
            this.stadiumsChoiceBox.setItems(stadiumsList);
        } catch (final SQLException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void update() {
        try {
            Match match = this.matchesTableView.getSelectionModel().getSelectedItem();

            if (match == null) {
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("update.fxml"));
            Parent parent = loader.load();

            UpdateController updateController = loader.getController();
            updateController.setUpdatingId(match.getId());

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
        Match match = this.matchesTableView.getSelectionModel().getSelectedItem();

        if (match == null) {
            return;
        }

        this.db.deleteByID(DB.MATCHES_TABLE, match.getId());
    }

    @FXML
    private final void search() {
        this.leagueFilter = this.leaguesChoiceBox.getValue();
        this.stadiumFilter = this.stadiumsChoiceBox.getValue();
        this.read();
    }

    private final void clearTextFields() {
        this.leagueNameTextField.clear();
        this.leagueCountryTextField.clear();
        this.stadiumNameTextField.clear();
        this.stadiumCountryTextField.clear();
        this.team1DescriptionTextArea.clear();
        this.team2DescriptionTextArea.clear();
    }
}
