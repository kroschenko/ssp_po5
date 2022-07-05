package com.example.lab9;

import dnl.utils.text.table.TextTable;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloApplication {


    public static void main(String[] args) {
        List<String> GroupName = new ArrayList<>();
        List<String> SubjectName = new ArrayList<>();
        List<String> FirstName = new ArrayList<>();
        List<String> LastName = new ArrayList<>();
        List<String> LessonTime = new ArrayList<>();
        List<String> LessonID = new ArrayList<>();
        List<List<String>> timetable = new ArrayList<>();
        List<String> timetableName = Arrays.asList("GroupName", "SubjectName", "FirstName", "LastName", "LessonTime", "LessonID");
        int count = 1;
        String connectionUrl = "jdbc:mysql://localhost:3306/spp_lab9";

        try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root")) {
            if (con.isValid(30)) {
                System.out.println("Success connection");

                Statement stmt = con.createStatement();
                System.out.println("\n SQL query: SELECT * FROM timetable");
                String selectThursday = "SELECT t.ID, g.GroupName, sub.SubjectName, l.FirstName, l.LastName, c.LessonTime, c.LessonID " +
                        "FROM timetable t " +
                        "    INNER JOIN groups g ON t.GroupID = g.ID " +
                        "    INNER JOIN subjects sub ON t.SubjectID = sub.ID " +
                        "    INNER JOIN lecturers l ON t.LecturerID = l.ID " +
                        "    INNER JOIN calendar c ON t.LessonID = c.ID " +
                        "WHERE t.WeekDay = 4 " +
                        "    AND g.GroupName = 'PO-5' " +
                        "ORDER BY t.LessonID";

                ResultSet rs = stmt.executeQuery(selectThursday);

                while (rs.next()) {
                    GroupName.add(rs.getString("GroupName"));
                    SubjectName.add(rs.getString("SubjectName"));
                    FirstName.add(rs.getString("FirstName"));
                    LastName.add(rs.getString("LastName"));
                    LessonTime.add(rs.getString("LessonTime"));
                    LessonID.add(rs.getString("LessonID"));
                    timetable.add(GroupName);
                    timetable.add(SubjectName);
                    timetable.add(FirstName);
                    timetable.add(LastName);
                    timetable.add(LessonTime);
                    timetable.add(LessonID);
                }
                TableModel tm = new TableModel() {
                    @Override
                    public int getRowCount() {
                        return timetable.get(0).size();
                    }

                    @Override
                    public int getColumnCount() {
                        return timetable.size();
                    }

                    @Override
                    public String getColumnName(int columnIndex) {

                        return timetableName.get(columnIndex);
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return timetable.getClass();
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return timetable.get(columnIndex) != null && timetable.get(columnIndex).get(rowIndex) != null;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return timetable.get(columnIndex).get(rowIndex);
                    }

                    @Override
                    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

                    }

                    @Override
                    public void addTableModelListener(TableModelListener l) {

                    }

                    @Override
                    public void removeTableModelListener(TableModelListener l) {

                    }
                };
                TextTable tt = new TextTable(tm);
                tt.printTable();

                System.out.println("\n SQL query: INSERT INTO groups (`GroupName`) VALUES ('TEST')");
                String addingTestGroup = "INSERT INTO groups (`GroupName`) VALUES ('TEST') ";
                stmt.execute(addingTestGroup);

                String readingTestGroup = "SELECT * FROM groups";
                ResultSet testGroupFirst = stmt.executeQuery(readingTestGroup);
                System.out.println("\n Table: groups");
                while (testGroupFirst.next()) {
                    System.out.println(count++ + ". " + testGroupFirst.getString("GroupName"));
                }

                System.out.println("\n SQL query: UPDATE groups SET GroupName='NORD' WHERE GroupName='TEST'");
                String updatingTestGroup = "UPDATE groups SET GroupName='NORD' WHERE GroupName='TEST'";
                stmt.execute(updatingTestGroup);

                ResultSet testGroupSecond = stmt.executeQuery(readingTestGroup);

                System.out.println("\n Table: groups");
                count = 1;
                while (testGroupSecond.next()) {
                    System.out.println(count++ + ". " + testGroupSecond.getString("GroupName"));
                }

                System.out.println("\n SQL query: DELETE FROM groups WHERE GroupName='NORD'");
                String deletingTestGroup = "DELETE FROM groups WHERE GroupName='NORD'";
                stmt.execute(deletingTestGroup);

                ResultSet testGroupThird = stmt.executeQuery(readingTestGroup);

                System.out.println("\n Table: groups");
                count = 1;
                while (testGroupThird.next()) {
                    System.out.println(count++ + ". " + testGroupThird.getString("GroupName"));
                }
            } else {
                System.out.println("Connection failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}