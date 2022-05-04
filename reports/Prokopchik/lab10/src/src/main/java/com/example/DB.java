package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DB {
    private final static String DATABASE_NAME = "lab10spp";
    public final static String LEAGUES_TABLE = "leagues";
    public final static String STADIUMS_TABLE = "stadiums";
    public final static String TEAM1_TABLE = "team1";
    public final static String TEAM2_TABLE = "team2";
    public final static String MATCHES_TABLE = "matches";

    private Connection connection = null;

    public DB() {
        try {
            final String HOST = "localhost";
            final String PORT = "3306";
            final String USERNAME = "root";
            final String PASSWORD = "root";
            final String URL = "jdbc:mysql://" + HOST + ':' + PORT;

            //Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL + "/?user=" + USERNAME + "&password=" + PASSWORD);
            this.prepare();
            //this.fill();
        } /*catch (final ClassNotFoundException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }*/ catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        } /*catch (final Exception exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        } */
    }

    public final void close() {
        try {
            this.connection.close();
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void prepare() {
        try {
            final String[] preparation = {
                    new String("CREATE DATABASE IF NOT EXISTS `" + DB.DATABASE_NAME + "`;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`"
                            + DB.LEAGUES_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`country` VARCHAR(64) NOT NULL , `short_name` VARCHAR(64) NOT NULL , PRIMARY KEY (`id`) , "
                            + "UNIQUE (`short_name`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`"
                            + DB.STADIUMS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`country` VARCHAR(64) NOT NULL , `short_name` VARCHAR(64) NOT NULL , "
                            + "PRIMARY KEY (`id`) , UNIQUE (`short_name`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`" +
                            DB.TEAM1_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`description` TEXT NULL , PRIMARY KEY (`id`) , UNIQUE (`name`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`" +
                            DB.TEAM2_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`description` TEXT NULL , PRIMARY KEY (`id`) , UNIQUE (`name`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`" +
                            DB.MATCHES_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `league_id` INT UNSIGNED NOT NULL , "
                            + "`stadium_id` INT UNSIGNED NOT NULL , `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , "
                            + "`team1_id` INT UNSIGNED NOT NULL , `team2_id` INT UNSIGNED NOT NULL , "
                            + "PRIMARY KEY (`id`) , INDEX `league_id_index` (`league_id`) , INDEX `stadium_id_index` (`stadium_id`) , "
                            + "INDEX `team1_id_index` (`team1_id`) , INDEX `team2_id_index` (`team2_id`) ) ENGINE = InnoDB;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.MATCHES_TABLE
                            + "` ADD FOREIGN KEY ( `league_id` ) REFERENCES `"
                            + DB.LEAGUES_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.MATCHES_TABLE
                            + "` ADD FOREIGN KEY ( `stadium_id` ) REFERENCES `"
                            + DB.STADIUMS_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.MATCHES_TABLE
                            + "` ADD FOREIGN KEY ( `team1_id` ) REFERENCES `" + DB.TEAM1_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.MATCHES_TABLE
                            + "` ADD FOREIGN KEY ( `team2_id` ) REFERENCES `" + DB.TEAM2_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("USE `" + DB.DATABASE_NAME + "`;")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : preparation) {
                statement.executeUpdate(sql);
            }
        } catch (final Exception exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public final ResultSet getAll(final String table) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            return statement
                    .executeQuery(new String(
                            "SELECT * FROM `" + DB.DATABASE_NAME + "`.`" + table + "` ORDER BY `id`;"));
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }

        return null;
    }

    public final ResultSet getMatches(final String leagueFilter, final String stadiumFilter, final Integer id) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            String sql = new String("SELECT "
                    + "`matches`.`id` , "
                    + "`leagues`.`short_name` AS `league` , "
                    + "`stadiums`.`short_name` AS `stadium` , "
                    + "`matches`.`date` , "
                    + "`team1`.`name` AS `team1` , "
                    + "`team2`.`name` AS `team2` "
                    + "FROM `matches` "
                    + "INNER JOIN `leagues` ON `matches`.`league_id` = `leagues`.`id` "
                    + "INNER JOIN `stadiums` ON `matches`.`stadium_id` = `stadiums`.`id` "
                    + "INNER JOIN `team1` ON `matches`.`team1_id` = `team1`.`id` "
                    + "INNER JOIN `team2` ON `matches`.`team2_id` = `team2`.`id`");

            if (id != null) {
                sql += " WHERE `matches`.`id` = '" + Integer.toString(id) + "';";
                return statement.executeQuery(sql);
            }

            if (leagueFilter != null && stadiumFilter != null) {
                sql += " WHERE `leagues`.`short_name` = '" + leagueFilter + "' AND `stadiums`.`short_name` = '" + stadiumFilter
                        + "';";
                return statement.executeQuery(sql);
            }

            if (leagueFilter != null) {
                sql += " WHERE `leagues`.`short_name` = '" + leagueFilter + "';";
                return statement.executeQuery(sql);
            }

            if (stadiumFilter != null) {
                sql += " WHERE `stadiums`.`short_name` = '" + stadiumFilter + "';";
                return statement.executeQuery(sql);
            }

            return statement.executeQuery(sql + ';');
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }

        return null;
    }

    public final ResultSet getMatchDetails(final Integer id) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            return statement
                    .executeQuery(new String("SELECT "
                            + "`leagues`.`name` AS `league_name` , "
                            + "`leagues`.`country` AS `league_country` , "
                            + "`stadiums`.`name` AS `stadium_name` , "
                            + "`stadiums`.`country` AS `stadium_country` , "
                            + "`team1`.`description` AS `team1_description` , "
                            + "`team2`.`description` AS `team2_description` "
                            + "FROM `matches` "
                            + "INNER JOIN `leagues` ON `matches`.`league_id` = `leagues`.`id` "
                            + "INNER JOIN `stadiums` ON `matches`.`stadium_id` = `stadiums`.`id` "
                            + "INNER JOIN `team1` ON `matches`.`team1_id` = `team1`.`id` "
                            + "INNER JOIN `team2` ON `matches`.`team2_id` = `team2`.`id` "
                            + "WHERE `matches`.`id` = '" + Integer.toString(id) + "';"));
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }

        return null;
    }

    public final void deleteByID(final String table, final Integer id) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();
            statement.executeUpdate(
                    "DELETE FROM `" + DB.DATABASE_NAME + "`.`" + table + "` WHERE `id` = '" + id + "\';");
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public final void addMatch(final Match match) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();
            ResultSet resultSet = null;

            resultSet = statement.executeQuery(
                    "SELECT `leagues`.`id` FROM `leagues` WHERE `short_name` = '" + match.getLeague() + "';");
            resultSet.next();
            Integer leagueId = resultSet.getInt("id");

            resultSet = statement
                    .executeQuery("SELECT `stadiums`.`id` FROM `stadiums` WHERE `short_name` = '" + match.getStadium() + "';");
            resultSet.next();
            Integer stadiumId = resultSet.getInt("id");

            resultSet = statement.executeQuery("SELECT `team1`.`id` FROM `team1` WHERE `name` = '" + match.getTeam1() + "';");
            resultSet.next();
            Integer team1Id = resultSet.getInt("id");

            resultSet = statement.executeQuery("SELECT `team2`.`id` FROM `team2` WHERE `name` = '" + match.getTeam2() + "';");
            resultSet.next();
            Integer team2Id = resultSet.getInt("id");

            String query = null;

            if (match.getId() == null) {
                query = new String("INSERT INTO `" + DB.MATCHES_TABLE
                        + "` (`id`, `league_id`, `stadium_id`, `date`, `team1_id`, `team2_id`) "
                        + "VALUES (NULL, '" + leagueId + "', '" + stadiumId + "', current_timestamp(), "
                        +Integer.toString(team1Id) + "', '" + Integer.toString(team2Id) + "');");

                statement.executeUpdate(query);
                return;
            }

              query = new String("UPDATE `" + DB.MATCHES_TABLE + "` SET "
                    + "`league_id` = '" + Integer.toString(leagueId)
                    + "' , `stadium_id` = '" + Integer.toString(stadiumId)
                    + "' , `date` = current_timestamp() , "
                    + "' , `team1_id` = '" + Integer.toString(team1Id)
                    + "' , `team2_id` = '" + Integer.toString(team2Id)
                    + "' WHERE `matches`.`id` = '" + Integer.toString(match.getId()) + "';");


            statement.executeUpdate(query);
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fill() {
        this.fillLeagues();
        this.fillStadiums();
        this.fillTeam1();
        this.fillTeam2();
        this.fillMatches();
    }

    private final void fillLeagues() {
        try {
            String[] leagues = {
                    new String("INSERT INTO `" + DB.LEAGUES_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Belarusian Premier League', 'Belarus', 'BPL');"),
                    new String("INSERT INTO `" + DB.LEAGUES_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Bundesliga', 'Germany', 'BL');"),
                    new String("INSERT INTO `" + DB.LEAGUES_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'UEFA', 'Europe', 'UEFA');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : leagues) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillStadiums() {
        try {
            String[] stadiums = {
                    new String("INSERT INTO `" + DB.STADIUMS_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Barysaŭ-Arena', 'Belarus', 'BA');"),
                    new String("INSERT INTO `" + DB.STADIUMS_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Westfalenstadion', 'Germany', 'WS');"),
                    new String("INSERT INTO `" + DB.STADIUMS_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Allianz Arena', 'Germany', 'AA');"),
                    new String("INSERT INTO `" + DB.STADIUMS_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Enfield', 'Enland', 'EF');"),
                    new String("INSERT INTO `" + DB.STADIUMS_TABLE
                            + "` (`id`, `name`, `country`, `short_name`) VALUES (NULL, 'Santiago-Bernabéu', 'Spain', 'SB');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : stadiums) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillTeam1() {
        try {
            String[] team1 = {
                    new String("INSERT INTO `" + DB.TEAM1_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'Dynamo Minsk', "
                            + "'Football team from Minsk, Belarus.');"),
                    new String("INSERT INTO `" + DB.TEAM1_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'Borussia', "
                            + "'Football team from Dortmund, Germany.');"),
                    new String("INSERT INTO `" + DB.TEAM1_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'VfB Stuttgart', "
                            + "'Football team from Stuttgart, Germany.');"),
                    new String("INSERT INTO `" + DB.TEAM1_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'Villarreal', "
                            + "'Football team from Villarreal, Spain.');"),
                    new String("INSERT INTO `" + DB.TEAM1_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'Real Madrid', "
                            + "'Football team from Madrid, Spain.');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : team1) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillTeam2() {
        try {
            String[] team2 = {
                    new String("INSERT INTO `" + DB.TEAM2_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'BATE', "
                            + "'Football team from Barysau, Belarus.');"),
                    new String("INSERT INTO `" + DB.TEAM2_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'FC Bayern München', "
                            + "'Football team from München, Germany.');"),
                    new String("INSERT INTO `" + DB.TEAM2_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'VfL Wolfsburg', "
                            + "'Football team from Wolfsburg, Germany.');"),
                    new String("INSERT INTO `" + DB.TEAM2_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'Liverpool FC', "
                            + "'Football team from Liverpool, England.');"),
                    new String("INSERT INTO `" + DB.TEAM2_TABLE
                            + "` (`id`, `name`, `description`) VALUES (NULL, 'Manchester City FC', "
                            + "'Football team from Manchester, England.');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : team2) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillMatches() {
        try {
            String[] matches = {
                    new String("INSERT INTO `" + DB.MATCHES_TABLE
                            + "` (`id`, `league_id`, `stadium_id`, `date`, `team1_id`, `team2_id`) "
                            + "VALUES (NULL, '1', '1', current_timestamp(), '1', '1');"),
                    new String("INSERT INTO `" + DB.MATCHES_TABLE
                            + "` (`id`, `league_id`, `stadium_id`, `date`, `team1_id`, `team2_id`) "
                            + "VALUES (NULL, '2', '2', current_timestamp(), '2', '2');"),
                    new String("INSERT INTO `" + DB.MATCHES_TABLE
                            + "` (`id`, `league_id`, `stadium_id`, `date`, `team1_id`, `team2_id`) "
                            + "VALUES (NULL, '2', '3', current_timestamp(), '3', '3');"),
                    new String("INSERT INTO `" + DB.MATCHES_TABLE
                            + "` (`id`, `league_id`, `stadium_id`, `date`, `team1_id`, `team2_id`) "
                            + "VALUES (NULL, '3', '4', current_timestamp(), '4', '4');"),
                    new String("INSERT INTO `" + DB.MATCHES_TABLE
                            + "` (`id`, `league_id`, `stadium_id`, `date`, `team1_id`, `team2_id`) "
                            + "VALUES (NULL, '3', '5', current_timestamp(), '5', '5');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : matches) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
