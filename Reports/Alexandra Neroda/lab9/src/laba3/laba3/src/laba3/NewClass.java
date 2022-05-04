package laba3;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClass {
    public static void main(String[] args) {
        // Connect
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/checkstudents";
        String username = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
            System.out.println("Connected to 'checkstudents'");
            }
            else{
                System.out.println("Failed connection!");
            }
            menu(conn);
        } 
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            if (conn != null) {
                try {
                    System.out.println("Connection close...");
                    conn.close();
                } 
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    public static void menu(Connection conn){
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet res = null;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("1)INSERT");
            System.out.println("2)SELECT");
            System.out.println("3)UPDATE");
            System.out.println("4)DELETE");
            System.out.println("5)SELECT and INSERT index");
            System.out.println("6)CheckInfo");
            System.out.println("7)Cascade Delete");
            System.out.println("0)Out");
            System.out.print("Input number: ");
            int n = in.nextInt();
            if(n < 0 || n > 6){
                System.out.println("You input error number!!!");
            }
            clearScreen();
            switch(n){
                case 1:
                    System.out.println("=================INSERT=================");
                    insert(conn, ps);
                    break;
                case 2:
                    System.out.println("=================SELECT=================");
                    select(conn, res, s);
                    break;
                case 3:
                    System.out.println("=================UPDATE=================");
                    update(conn, ps);
                    break;
                case 4:
                    System.out.println("=================DELETE=================");
                    delete(conn, ps);
                    break;
                case 5:
                    System.out.println("=================SELECT and INSERT index=================");
                    selins(conn, s, ps, res);
                    break;
                case 6:
                    System.out.println("=================Stud Info=================");
                    checkInfo(conn, s, ps, res);
                    break;
                case 7:
                    System.out.println("=================Cascade Delete=================");
                    cascadeDelete(conn, ps);
                    break;    
                case 0:
                    System.out.println("End the program...");
                    System.exit(0);
            }
        }
        while(true);
    }
    
    static void insert(Connection conn, PreparedStatement ps){
        try {
            // INSERT
            System.out.println("Запрос INSERT... predmet");
            String sql_ins2 = "INSERT INTO predmet (name, kod) VALUES (?,?)";
            ps = conn.prepareStatement(sql_ins2);
            ps.setString(1, "Математика");
            ps.setInt(2, 4);
            int rowsInserted2 = ps.executeUpdate();
            if (rowsInserted2 > 0) {
                System.out.println("Новый предмет упешно добавлен!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос INSERT... student");
            String sql_ins = "INSERT INTO student (fname, lname) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins);
            ps.setString(1, "Никита");
            ps.setString(2, "Никитин");
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Новый студент упешно добавлен!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос INSERT... vedomost");
            String sql_ins3 = "INSERT INTO vedomost (data, mark) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins3);
            ps.setString(1, "09.12.2021");
            ps.setInt(2, 6);
            int rowsInserted3 = ps.executeUpdate();
            if (rowsInserted3 > 0) {
                System.out.println("Новая ведомость упешно добавлена!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос INSERT... grandsp");
            String sql_ins4 = "INSERT INTO grandsp (spes, grupa) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins4);
            ps.setString(1, "ПОИТ");
            ps.setString(2, "ПО-9");
            int rowsInserted4 = ps.executeUpdate();
            if (rowsInserted4 > 0) {
                System.out.println("Новые спец. и группа упешно добавлены!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();

        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void select(Connection conn, ResultSet res, Statement s){
        try {
            // SELECT
            System.out.println("Запрос SELECT... predmet");
            String sql_sel2 = "SELECT * FROM predmet";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int count2 = 0;
            while (res.next()){
                String name = res.getString(2);
                int number = res.getInt(3);
                System.out.println("Название предмета: " + name);
                System.out.println("Код предмета: " + number);
                count2++;
            }
            System.out.println("Количество предметов = " + count2);
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос SELECT... student");
            String sql_sel = "SELECT * FROM student";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel);
            int count = 0;
            while (res.next()){
                String fname = res.getString(2);
                String lname = res.getString(3);
                System.out.println("Имя студента: " + fname);
                System.out.println("Фамилия студента: " + lname);
                count++;
            }
            System.out.println("Количество студентов = " + count);
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос SELECT... vedomost");
            String sql_sel3 = "SELECT * FROM vedomost";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            int count3 = 0;
            while (res.next()){
                String data = res.getString(2);
                int coun = res.getInt(3);
                System.out.println("Дата сдачи: " + data);
                System.out.println("Оценка: " + coun);
                count3++;
            }
            System.out.println("Количество ведомостей = " + count3);
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос SELECT... grandsp");
            String sql_sel4 = "SELECT * FROM grandsp";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            int count4 = 0;
            while (res.next()){
                String spes = res.getString(2);
                String grupa = res.getString(3);
                System.out.println("Специальность: " + spes);
                System.out.println("Группа: " + grupa);
                count4++;
            }
            System.out.println("Количество спец. и групп = " + count4);
            System.out.println("--------------------------------------------------------");
            System.out.println();

        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void update(Connection conn, PreparedStatement ps){
        try {
            // UPDATE
            System.out.println("Запрос UPDATE... predmet");
            String sql_up2 = "UPDATE predmet SET name=?, kod=? WHERE name=?";
            ps = conn.prepareStatement(sql_up2);
            ps.setString(1, "ОАИП");
            ps.setInt(2, 2);
            ps.setString(3, "Математика");
            int rowsUpdated2 = ps.executeUpdate();
            if (rowsUpdated2 > 0) {
                System.out.println("Данные предмета успешно изменены!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос UPDATE... student");
            String sql_up = "UPDATE student SET fname=?, lname=? WHERE id_s=?";
            ps = conn.prepareStatement(sql_up);
            ps.setString(1, "Петя");
            ps.setString(2, "Петров");
            ps.setInt(3, 1);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Данные студента успешно изменены!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void delete(Connection conn, PreparedStatement ps){
        try {
            // DELETE
            System.out.println("Запрос DELETE... vedomost");
            String sql_del2 = "DELETE FROM vedomost WHERE id_v=?";
            ps = conn.prepareStatement(sql_del2);
            ps.setInt(1, 1);
            int rowsDeleted2 = ps.executeUpdate();
            if (rowsDeleted2 > 0) {
                System.out.println("Данные ведомости успешно удалены!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос DELETE... grandsp");
            String sql_del = "DELETE FROM grandsp WHERE id_g=?";
            ps = conn.prepareStatement(sql_del);
            ps.setInt(1, 1);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Данные спец. и групп успешно удалены!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void cascadeDelete(Connection conn, PreparedStatement ps){
        try {
            // DELETE
            Scanner in = new Scanner(System.in);
            System.out.println("Запрос DELETE... checkinfo");
            System.out.print("Введите id: ");
            int di = in.nextInt();
            
            String sql_del2 = "DELETE FROM vedomost WHERE id_v=?";
            ps = conn.prepareStatement(sql_del2);
            ps.setInt(1, di);
            int rowsDelete2 = ps.executeUpdate();
            if (rowsDelete2 > 0) {
                System.out.println("Данные успешно удалены!");
            }
            
            String sql_del = "DELETE FROM grandsp WHERE id_g=?";
            ps = conn.prepareStatement(sql_del);
            ps.setInt(1, di);
            int rowsDelete = ps.executeUpdate();
            if (rowsDelete > 0) {
                System.out.println("Данные успешно удалены!");
            }
            
            String sql_del3 = "DELETE FROM indexes WHERE id=?";
            ps = conn.prepareStatement(sql_del3);
            ps.setInt(1, di);
            int rowsDelete3 = ps.executeUpdate();
            if (rowsDelete3 > 0) {
                System.out.println("Данные успешно удалены!");
            }
            
            String sql_del4 = "DELETE FROM predmet WHERE id_p=?";
            ps = conn.prepareStatement(sql_del4);
            ps.setInt(1, di);
            int rowsDelete4 = ps.executeUpdate();
            if (rowsDelete4 > 0) {
                System.out.println("Данные успешно удалены!");
            }
            
            String sql_del5 = "DELETE FROM student WHERE id_s=?";
            ps = conn.prepareStatement(sql_del5);
            ps.setInt(1, di);
            int rowsDelete5 = ps.executeUpdate();
            if (rowsDelete5 > 0) {
                System.out.println("Данные успешно удалены!");
            }
            
            String sql_delete = "DELETE FROM checkinfo WHERE id_ch=?";
            ps = conn.prepareStatement(sql_delete);
            ps.setInt(1, di);
            int rowsDelete6 = ps.executeUpdate();
            if (rowsDelete6 > 0) {
                System.out.println("Данные checkinfo по id = (" + di + ") успешно удалены!");
            }
            System.out.println("---------------------------------------------------");
            System.out.println();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void selins(Connection conn, Statement s, PreparedStatement ps, ResultSet res){
        try
        {
            String sql = "select count(*) from student";
            s = conn.createStatement();
            res = s.executeQuery(sql);
            int count = 0;
            while(res.next()){
                count = res.getInt(1);
            }
            System.out.println("count = " + count);
            
            String sql_sel = "select id_s from student";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel);
            int prod = 0;
            int[] r = new int[count];
            int i = 0;
            while (res.next()){
                prod = res.getInt(1);
                r[i] = prod;
                i++;
            }
            
            String sql_sel2 = "select id_v from vedomost";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int data = 0;
            int[] d = new int[count];
            int j = 0;
            while (res.next()){
                data = res.getInt(1);
                d[j] = data;
                j++;
            }
            
            String sql_sel3 = "select id_g from grandsp";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            int work = 0;
            int[] w = new int[count];
            int l = 0;
            while (res.next()){
                work = res.getInt(1);
                w[l] = work;
                l++;
            }
            
            String sql_sel4 = "select id_p from predmet";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            int predmet = 0;
            int[] t = new int[count];
            int e = 0;
            while (res.next()){
                predmet = res.getInt(1);
                t[e] = predmet;
                e++;
            }
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                ps = conn.prepareStatement("insert into indexes(predmet_id, vedom_id, stud_id, grsp_id) values(?,?,?,?)");
                ps.setInt(1, t[p]);
                ps.setInt(2, d[p]);
                ps.setInt(3, r[p]);
                ps.setInt(4, w[p]);
                k = ps.executeUpdate(); 
            }
            if(k > 0){
                System.out.println("Данные индексов успешно добавлены!");
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void checkInfo(Connection conn, Statement s, PreparedStatement ps, ResultSet res){
        try 
        {
            String sql = "select count(*) from student";
            s = conn.createStatement();
            res = s.executeQuery(sql);
            int count = 0;
            while(res.next()){
                count = res.getInt(1);
            }
            System.out.println("count = " + count);
            
            
            String sql_sel2 = "select data, mark from vedomost";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int coun = 0;
            String data;
            int[] c = new int[count];
            String[] dat = new String[count];
            int j = 0;
            while (res.next()){
                data = res.getString("data");
                dat[j] = data;
                coun = res.getInt("mark");
                c[j] = coun;
                j++;
            }
            
            System.out.println("data: " + Arrays.toString(dat));
            System.out.println("mark: " + Arrays.toString(c));
            
            
            String sql_sel3 = "select fname, lname from student";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            String fname;
            String lname;
            String[] sm = new String[count];
            String[] em = new String[count];
            int l = 0;
            while (res.next()){
                fname = res.getString("fname");
                sm[l] = fname;
                lname = res.getString("lname");
                em[l] = lname;
                l++;
            }
            
            System.out.println("fname: " + Arrays.toString(sm));
            System.out.println("lname: " + Arrays.toString(em));
            
            
            String sql_sel4 = "select spes, grupa from grandsp";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            String starttime;
            String endtime;
            String[] st = new String[count];
            String[] et = new String[count];
            int q = 0;
            while (res.next()){
                starttime = res.getString("spes");
                st[q] = starttime;
                endtime = res.getString("grupa");
                et[q] = endtime;
                q++;
            }
            
            System.out.println("spes: " + Arrays.toString(st));
            System.out.println("grupa: " + Arrays.toString(et));
            
            String sql_sel5 = "select name, kod from predmet";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel5);
            String name;
            int kod;
            String[] n = new String[count];
            int[] num = new int[count];
            int w = 0;
            while (res.next()){
                name = res.getString("name");
                n[w] = name;
                kod = res.getInt("kod");
                num[w] = kod;
                w++;
            }
            
            System.out.println("name: " + Arrays.toString(n));
            System.out.println("kod: " + Arrays.toString(num));
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                ps = conn.prepareStatement("insert into checkinfo(name, kod, data, mark, spes, grupa, fname, lname) values(?,?,?,?,?,?,?,?)");
                ps.setString(1, n[p]);
                ps.setInt(2, num[p]);
                ps.setString(3, dat[p]);
                ps.setInt(4, c[p]);
                ps.setString(5, st[p]);
                ps.setString(6, et[p]);
                ps.setString(7, sm[p]);
                ps.setString(8, em[p]);
                k = ps.executeUpdate();
            }
            
            if(k > 0){
                System.out.println("Данные успешно добавлены");
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
