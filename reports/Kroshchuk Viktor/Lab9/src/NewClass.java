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
        String url = "jdbc:mysql://localhost:3306/prokat";
        String username = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
            System.out.println("Connected to 'prokat'");
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
            System.out.println("6)Prokat Info");
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
                    System.out.println("=================Prokat Info=================");
                    prokatInfo(conn, s, ps, res);
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
            System.out.println("Запрос INSERT... tovar");
            String sql_ins2 = "INSERT INTO tovar (name, kod) VALUES (?,?)";
            ps = conn.prepareStatement(sql_ins2);
            ps.setString(1, "Касета");
            ps.setInt(2, 23);
            int rowsInserted2 = ps.executeUpdate();
            if (rowsInserted2 > 0) {
                System.out.println("Новый товар упешно добавлен!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос INSERT... prodavec");
            String sql_ins = "INSERT INTO prodavec (fnameprod, lnameprod) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins);
            ps.setString(1, "Иван");
            ps.setString(2, "Иванов");
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Новый продавец упешно добавлен!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос INSERT... dateofintro");
            String sql_ins3 = "INSERT INTO dateofintro (data, count) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins3);
            ps.setString(1, "09.12.2021");
            ps.setInt(2, 6);
            int rowsInserted3 = ps.executeUpdate();
            if (rowsInserted3 > 0) {
                System.out.println("Новая дата упешно добавлена!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос INSERT... worktime");
            String sql_ins4 = "INSERT INTO worktime (startw, endw) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins4);
            ps.setString(1, "9:00");
            ps.setString(2, "21:40");
            int rowsInserted4 = ps.executeUpdate();
            if (rowsInserted4 > 0) {
                System.out.println("Новое время работы упешно добавлено!");
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
            System.out.println("Запрос SELECT... tovar");
            String sql_sel2 = "SELECT * FROM tovar";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int count2 = 0;
            while (res.next()){
                String name = res.getString(2);
                int number = res.getInt(3);
                System.out.println("Название товара: " + name);
                System.out.println("Код товара: " + number);
                count2++;
            }
            System.out.println("Количество товаров = " + count2);
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос SELECT... prodavec");
            String sql_sel = "SELECT * FROM prodavec";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel);
            int count = 0;
            while (res.next()){
                String fname = res.getString(2);
                String lname = res.getString(3);
                System.out.println("Имя продавца: " + fname);
                System.out.println("Фамилия продавца: " + lname);
                count++;
            }
            System.out.println("Количество продавцов = " + count);
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос SELECT... dateofintro");
            String sql_sel3 = "SELECT * FROM dateofintro";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            int count3 = 0;
            while (res.next()){
                String data = res.getString(2);
                int coun = res.getInt(3);
                System.out.println("Дата регистрации: " + data);
                System.out.println("Стоимость проката: " + coun);
                count3++;
            }
            System.out.println("Количество дат = " + count3);
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос SELECT... worktime");
            String sql_sel4 = "SELECT * FROM worktime";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            int count4 = 0;
            while (res.next()){
                String startw = res.getString(2);
                String endw = res.getString(3);
                System.out.println("Начало времени проката: " + startw);
                System.out.println("Конец времени проката: " + endw);
                count4++;
            }
            System.out.println("Количество графиков времён = " + count4);
            System.out.println("--------------------------------------------------------");
            System.out.println();

        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void update(Connection conn, PreparedStatement ps){
        try {
            // UPDATE
            System.out.println("Запрос UPDATE... tovar");
            String sql_up2 = "UPDATE tovar SET name=?, kod=? WHERE name=?";
            ps = conn.prepareStatement(sql_up2);
            ps.setString(1, "Велосипед");
            ps.setInt(2, 5);
            ps.setString(3, "Касета");
            int rowsUpdated2 = ps.executeUpdate();
            if (rowsUpdated2 > 0) {
                System.out.println("Данные товара успешно изменены!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос UPDATE... prodavec");
            String sql_up = "UPDATE prodavec SET fnameprod=?, lnameprod=? WHERE id_p=?";
            ps = conn.prepareStatement(sql_up);
            ps.setString(1, "Петров");
            ps.setString(2, "Петя");
            ps.setInt(3, 1);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Данные продавца успешно изменены!");
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
            System.out.println("Запрос DELETE... dateofintro");
            String sql_del2 = "DELETE FROM dateofintro WHERE id_d=?";
            ps = conn.prepareStatement(sql_del2);
            ps.setInt(1, 1);
            int rowsDeleted2 = ps.executeUpdate();
            if (rowsDeleted2 > 0) {
                System.out.println("Данные даты успешно удалены!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("Запрос DELETE... worktime");
            String sql_del = "DELETE FROM worktime WHERE id_w=?";
            ps = conn.prepareStatement(sql_del);
            ps.setInt(1, 1);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Данные времени успешно удалены!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void selins(Connection conn, Statement s, PreparedStatement ps, ResultSet res){
        try
        {
            String sql = "select count(*) from prodavec";
            s = conn.createStatement();
            res = s.executeQuery(sql);
            int count = 0;
            while(res.next()){
                count = res.getInt(1);
            }
            System.out.println("count = " + count);
            
            String sql_sel = "select id_p from prodavec";
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
            
            String sql_sel2 = "select id_d from dateofintro";
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
            
            String sql_sel3 = "select id_w from worktime";
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
            
            String sql_sel4 = "select id_t from tovar";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            int tovar = 0;
            int[] t = new int[count];
            int e = 0;
            while (res.next()){
                tovar = res.getInt(1);
                t[e] = tovar;
                e++;
            }
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                ps = conn.prepareStatement("insert into indexes(tovar_id, data_id, prod_id, work_id) values(?,?,?,?)");
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
    
    static void prokatInfo(Connection conn, Statement s, PreparedStatement ps, ResultSet res){
        try 
        {
            String sql = "select count(*) from prodavec";
            s = conn.createStatement();
            res = s.executeQuery(sql);
            int count = 0;
            while(res.next()){
                count = res.getInt(1);
            }
            System.out.println("count = " + count);
            
            
            String sql_sel2 = "select data, count from dateofintro";
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
                coun = res.getInt("count");
                c[j] = coun;
                j++;
            }
            
            System.out.println("data: " + Arrays.toString(dat));
            System.out.println("count: " + Arrays.toString(c));
            
            
            String sql_sel3 = "select fnameprod, lnameprod from prodavec";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            String fnameprod;
            String lnameprod;
            String[] sm = new String[count];
            String[] em = new String[count];
            int l = 0;
            while (res.next()){
                fnameprod = res.getString("fnameprod");
                sm[l] = fnameprod;
                lnameprod = res.getString("lnameprod");
                em[l] = lnameprod;
                l++;
            }
            
            System.out.println("fnameprod: " + Arrays.toString(sm));
            System.out.println("lnameprod: " + Arrays.toString(em));
            
            
            String sql_sel4 = "select startw, endw from worktime";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            String starttime;
            String endtime;
            String[] st = new String[count];
            String[] et = new String[count];
            int q = 0;
            while (res.next()){
                starttime = res.getString("startw");
                st[q] = starttime;
                endtime = res.getString("endw");
                et[q] = endtime;
                q++;
            }
            
            System.out.println("startw: " + Arrays.toString(st));
            System.out.println("endw: " + Arrays.toString(et));
            
            String sql_sel5 = "select name, kod from tovar";
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
                ps = conn.prepareStatement("insert into prokatinfo(name, kod, data, count, startw, endw, fnameprod, lnameprod) values(?,?,?,?,?,?,?,?)");
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
