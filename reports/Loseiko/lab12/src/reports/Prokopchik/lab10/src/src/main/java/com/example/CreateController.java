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
    private ChoiceBox<String> leaguesChoiceBox;
    @FXML
    private ChoiceBox<String> stadiumsChoiceBox;
    @FXML
    private ChoiceBox<String> team1ChoiceBox;
    @FXML
    private ChoiceBox<String> team2ChoiceBox;

    private DB db = null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            this.db = new DB();

            ObservableList<String> leaguesList = FXCollections.observableArrayList();
            ObservableList<String> stadiumsList = FXCollections.observableArrayList();
            ObservableList<String> team1List = FXCollections.observableArrayList();
            ObservableList<String> team2List = FXCollections.observableArrayList();

            ResultSet leaguesSet = this.db.getAll(DB.LEAGUES_TABLE);
            ResultSet stadiumsSet = this.db.getAll(DB.STADIUMS_TABLE);
            ResultSet team1Set = this.db.getAll(DB.TEAM1_TABLE);
            ResultSet team2Set = this.db.getAll(DB.TEAM2_TABLE);

            while (leaguesSet.next() && stadiumsSet.next() && team1Set.next() && team2Set.next()) {
                leaguesList.add(leaguesSet.getString("short_name"));
                stadiumsList.add(stadiumsSet.getString("short_name"));
                team1List.add(team1Set.getString("name"));
                team2List.add(team2Set.getString("name"));
            }

            this.leaguesChoiceBox.setItems(leaguesList);
            this.stadiumsChoiceBox.setItems(stadiumsList);
            this.team1ChoiceBox.setItems(team1List);
            this.team2ChoiceBox.setItems(team2List);
        } catch (final SQLException exception) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void create() {
        if (this.leaguesChoiceBox.getSelectionModel().isEmpty()
                || this.stadiumsChoiceBox.getSelectionModel().isEmpty()
                || this.team1ChoiceBox.getSelectionModel().isEmpty()
                || this.team2ChoiceBox.getSelectionModel().isEmpty()) {
            return;
        }

        this.db.addMatch(new Match(null,
                this.leaguesChoiceBox.getValue(),
                this.stadiumsChoiceBox.getValue(),
                null,
                this.team1ChoiceBox.getValue(),
                this.team2ChoiceBox.getValue()));
    }
}
