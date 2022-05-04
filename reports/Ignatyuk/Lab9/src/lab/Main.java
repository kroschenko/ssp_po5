package lab;

import java.sql.*;
import java.util.ArrayList;

public final class Main {
    private final static String DATABASE_NAME = "lab";
    private final static String CUSTOMERS_TABLE = "customers";
    private final static String WORKERS_TABLE = "workers";
    private final static String CPU_TABLE = "cpu";
    private final static String GPU_TABLE = "gpu";
    private final static String ORDERS_TABLE = "orders";

    private final static String HOST = "localhost";
    private final static String PORT = "3306";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "secret";
    private final static String URL = "jdbc:mysql://" + HOST + ':' + PORT;

    private final static void create() {
        try {
            String[] create = {
                    new String("CREATE DATABASE IF NOT EXISTS `" + DATABASE_NAME + "`;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DATABASE_NAME + "`.`"
                            + CUSTOMERS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(64) NOT NULL , "
                            + "`last_name` VARCHAR(64) NOT NULL , `email` VARCHAR(64) NOT NULL , PRIMARY KEY (`id`) , "
                            + "UNIQUE (`email`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DATABASE_NAME + "`.`"
                            + WORKERS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(64) NOT NULL , "
                            + "`last_name` VARCHAR(64) NOT NULL , `email` VARCHAR(64) NOT NULL , `position` VARCHAR(64) NOT NULL , "
                            + "PRIMARY KEY (`id`) , UNIQUE (`email`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DATABASE_NAME + "`.`" + CPU_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`price` DOUBLE UNSIGNED NOT NULL , `description` TEXT NULL , PRIMARY KEY (`id`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DATABASE_NAME + "`.`" + GPU_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`price` DOUBLE UNSIGNED NOT NULL , `description` TEXT NULL , PRIMARY KEY (`id`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DATABASE_NAME + "`.`" + ORDERS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `customer_id` INT UNSIGNED NOT NULL , "
                            + "`worker_id` INT UNSIGNED NOT NULL , `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , "
                            + "`price` DOUBLE UNSIGNED NOT NULL, `cpu_id` INT UNSIGNED NOT NULL , `gpu_id` INT UNSIGNED NOT NULL , "
                            + "PRIMARY KEY (`id`) , INDEX `customer_id_index` (`customer_id`) , INDEX `worker_id_index` (`worker_id`) , "
                            + "INDEX `cpu_id_index` (`cpu_id`) , INDEX `gpu_id_index` (`gpu_id`) ) ENGINE = InnoDB;"),
                    new String("ALTER TABLE `" + DATABASE_NAME + "`.`" + ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `customer_id` ) REFERENCES `"
                            + CUSTOMERS_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DATABASE_NAME + "`.`" + ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `worker_id` ) REFERENCES `"
                            + WORKERS_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DATABASE_NAME + "`.`" + ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `cpu_id` ) REFERENCES `" + CPU_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DATABASE_NAME + "`.`" + ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `gpu_id` ) REFERENCES `" + GPU_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;")
            };

            Connection connection = DriverManager
                    .getConnection(URL + "/?user=" + USERNAME + "&password=" + PASSWORD);
            Statement statement = connection.createStatement();

            for (final String sql : create) {
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
            System.out.println("Database " + DATABASE_NAME + " has been created successfully!");
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void fill() {
        fillCustomers();
        fillWorkers();
        fillCPU();
        fillGPU();
        fillOrders();
    }

    private final static void fillCustomers() {
        try {
            String[] customers = {
                    new String("INSERT INTO `" + CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Gale', 'Bean', 'Gale_Bean@gmail.com');"),
                    new String("INSERT INTO `" + CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Abel', 'Wood', 'Abel_Wood@gmail.com');"),
                    new String("INSERT INTO `" + CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Roosevelt', 'Glover', 'Roosevelt_Glover@gmail.com');"),
                    new String("INSERT INTO `" + CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Avery', 'Schaefer', 'Avery_Schaefer@gmail.com');"),
                    new String("INSERT INTO `" + CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Terry', 'Duffy', 'Terry_Duffy@gmail.com');")
            };

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();

            for (final String sql : customers) {
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
            System.out.println(
                    "Database " + DATABASE_NAME + " has been filled with customers successfully!");
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void fillWorkers() {
        try {
            String[] workers = {
                    new String("INSERT INTO `" + WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Lilac', 'Rick', 'Lilac_Rick@gmail.com', 'junior');"),
                    new String("INSERT INTO `" + WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Abilene', 'Debra', 'Abilene_Debra@gmail.com', 'senior');"),
                    new String("INSERT INTO `" + WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Caroline', 'Jean', 'Caroline_Jean@gmail.com', 'junior');"),
                    new String("INSERT INTO `" + WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Kiki', 'Gene', 'Kiki_Gene@gmail.com', 'middle');"),
                    new String("INSERT INTO `" + WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Joanie', 'Julianne', 'Joanie_Julianne@gmail.com', 'middle');")
            };

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();

            for (final String sql : workers) {
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
            System.out.println("Database " + DATABASE_NAME + " has been filled with workers successfully!");
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void fillCPU() {
        try {
            String[] CPU = {
                    new String("INSERT INTO `" + CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Ryzen 3 4100', 99.00, "
                            + "'The AMD Ryzen 3 4100 is a desktop processor with 4 cores, launched in April 2022. "
                            + "It is part of the Ryzen 3 lineup, using the Zen 2 (Renoir) architecture with Socket AM4.');"),
                    new String("INSERT INTO `" + CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Ryzen 7 5800X3D', 449.00, "
                            + "'The AMD Ryzen 7 5800X3D is a desktop processor with 8 cores, launched in April 2022. "
                            + "It is part of the Ryzen 7 lineup, using the Zen 3 (Vermeer) architecture with Socket AM4.');"),
                    new String("INSERT INTO `" + CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD FX-6300', 132.00, 'The AMD FX-6300 was "
                            + "a desktop processor with 6 cores, launched in October 2012. It is part of the FX lineup, using the "
                            + "Vishera architecture with Socket AM3+. FX-6300 has 8MB of L3 cache and operates at 3.5 GHz by default, "
                            + "but can boost up to 4.1 GHz, depending on the workload.');"),
                    new String("INSERT INTO `" + CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'Intel Core i5-10400F', 220.00, "
                            + "'The Intel Core i5-10400F is a desktop processor with 6 cores, launched in April 2020. It is part "
                            + "of the Core i5 lineup, using the Comet Lake architecture with Socket 1200. Thanks to Intel "
                            + "Hyper-Threading the core-count is effectively doubled, to 12 threads. Core i5-10400F has 12MB of L3 cache "
                            + "and operates at 2.9 GHz by default, but can boost up to 4.3 GHz.');"),
                    new String("INSERT INTO `" + CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'Intel Core i9-12900K', 599.00, "
                            + "'The Intel Core i9-12900K is a desktop processor with 16 cores, launched in November 2021. "
                            + "It is part of the Core i9 lineup, using the Alder Lake-S architecture with Socket 1700. Thanks "
                            + "to Intel Hyper-Threading the core-count is effectively doubled, to 24 threads. Core i9-12900K has "
                            + "30MB of L3 cache and operates at 3.2 GHz by default, but can boost up to 5.2 GHz.');")
            };

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();

            for (final String sql : CPU) {
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
            System.out.println("Database " + DATABASE_NAME + " has been filled with cpu successfully!");
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void fillGPU() {
        try {
            String[] GPU = {
                    new String("INSERT INTO `" + GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'NVIDIA GeForce RTX 3060', 329.00, "
                            + "'The GeForce RTX 3060 is a performance-segment graphics card by NVIDIA, launched on January 12th, 2021. "
                            + "Built on the 8 nm process, and based on the GA106 graphics processor, in its GA106-300-A1 variant, "
                            + "the card supports DirectX 12 Ultimate.');"),
                    new String("INSERT INTO `" + GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Radeon RX 6600 XT', 379.00, "
                            + "'The Radeon RX 6600 XT is a performance-segment graphics card by AMD, launched on July 30th, 2021. "
                            + "Built on the 7 nm process, and based on the Navi 23 graphics processor, in its Navi 23 XT variant, "
                            + "the card supports DirectX 12 Ultimate.');"),
                    new String("INSERT INTO `" + GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'NVIDIA GeForce GTX 1060 6 GB', 299.00, "
                            + "'The GeForce GTX 1060 6 GB was a performance-segment graphics card by NVIDIA, launched on July 19th, 2016. "
                            + "Built on the 16 nm process, and based on the GP106 graphics processor, in its GP106-400-A1 variant, "
                            + "the card supports DirectX 12.');"),
                    new String("INSERT INTO `" + GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Radeon RX 6700 XT', 479.00, "
                            + "'The Radeon RX 6700 XT is a high-end graphics card by AMD, launched on March 3rd, 2021. "
                            + "Built on the 7 nm process, and based on the Navi 22 graphics processor, in its Navi 22 XT variant, "
                            + "the card supports DirectX 12 Ultimate.');"),
                    new String("INSERT INTO `" + GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'NVIDIA GeForce GTX 1080', 599.00, "
                            + "'The GeForce GTX 1080 was a high-end graphics card by NVIDIA, launched on May 27th, 2016. "
                            + "Built on the 16 nm process, and based on the GP104 graphics processor, in its GP104-400-A1 variant, "
                            + "the card supports DirectX 12.');")
            };

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();

            for (final String sql : GPU) {
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
            System.out.println("Database " + DATABASE_NAME + " has been filled with gpu successfully!");
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void fillOrders() {
        try {
            String[] orders = {
                    new String("INSERT INTO `" + ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '3', '2', current_timestamp(), 549.00, '4', '1');"),
                    new String("INSERT INTO `" + ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '5', '1', current_timestamp(), 748.00, '2', '3');"),
                    new String("INSERT INTO `" + ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '4', '5', current_timestamp(), 478.00, '1', '2');"),
                    new String("INSERT INTO `" + ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '2', '3', current_timestamp(), 1078.00, '5', '4');"),
                    new String("INSERT INTO `" + ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '1', '4', current_timestamp(), 731.00, '3', '5');")
            };

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();

            for (final String sql : orders) {
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
            System.out.println("Database " + DATABASE_NAME + " has been filled with orders successfully!");
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void print() {
        printCustomers();
        printWorkers();
        printCPU();
        printGPU();
        printOrders();
    }

    private final static void printCustomers() {
        try {
            System.out.println("Printing customers...\n");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(new String(
                            "SELECT * FROM `" + DATABASE_NAME + "`.`" + CUSTOMERS_TABLE + "` ORDER BY `first_name`;"));

            while (result.next()) {
                System.out.println("ID : " + result.getInt("id")
                        + "\nFirst Name : " + result.getString("first_name")
                        + "\nLast Name : " + result.getString("last_name")
                        + "\nEmail : " + result.getString("email") + '\n');
            }

            result.close();
            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void printWorkers() {
        try {
            System.out.println("Printing workers...\n");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(new String(
                            "SELECT * FROM `" + DATABASE_NAME + "`.`" + WORKERS_TABLE + "` ORDER BY `first_name`;"));

            while (result.next()) {
                System.out.println("ID : " + result.getInt("id")
                        + "\nFirst Name : " + result.getString("first_name")
                        + "\nLast Name : " + result.getString("last_name")
                        + "\nPosition : " + result.getString("position")
                        + "\nEmail : " + result.getString("email") + '\n');
            }

            result.close();
            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void printCPU() {
        try {
            System.out.println("Printing CPU...\n");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(
                            new String("SELECT * FROM `" + DATABASE_NAME + "`.`" + CPU_TABLE + "`  ORDER BY `price`;"));

            while (result.next()) {
                System.out.println("ID : " + result.getInt("id")
                        + "\nName : " + result.getString("name")
                        + "\nPrice : " + result.getDouble("price")
                        + "\nDescription : " + result.getString("description") + '\n');
            }

            result.close();
            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void printGPU() {
        try {
            System.out.println("Printing GPU...\n");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(
                            new String("SELECT * FROM `" + DATABASE_NAME + "`.`" + GPU_TABLE + "` ORDER BY `price`;"));

            while (result.next()) {
                System.out.println("ID : " + result.getInt("id")
                        + "\nName : " + result.getString("name")
                        + "\nPrice : " + result.getDouble("price")
                        + "\nDescription : " + result.getString("description") + '\n');
            }

            result.close();
            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void printOrders() {
        try {
            System.out.println("Printing orders...\n");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(new String(
                            "SELECT * FROM `" + DATABASE_NAME + "`.`" + ORDERS_TABLE + "` ORDER BY `date`;"));

            while (result.next()) {
                System.out.println("ID : " + result.getInt("id")
                        + "\nCustomer ID : " + result.getInt("customer_id")
                        + "\nWorker ID : " + result.getInt("worker_id")
                        + "\nDate : " + result.getDate("date")
                        + "\nPrice : " + result.getDouble("price")
                        + "\nCPU ID : " + result.getInt("cpu_id")
                        + "\nGPU ID : " + result.getInt("gpu_id") + '\n');
            }

            result.close();
            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void popBack() {
        System.out.println("Deleting last order...\n");
        popBack(ORDERS_TABLE);
        System.out.println("Deleting last customer...\n");
        popBack(CUSTOMERS_TABLE);
        System.out.println("Deleting last worker...\n");
        popBack(WORKERS_TABLE);
        System.out.println("Deleting last CPU...\n");
        popBack(CPU_TABLE);
        System.out.println("Deleting last GPU...\n");
        popBack(GPU_TABLE);
    }

    private final static void popBack(final String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(new String(
                            "SELECT * FROM `" + DATABASE_NAME + "`.`" + table + "` ORDER BY `id`;"));

            int lastID = -1;

            while (result.next()) {
                lastID = result.getInt("id");
            }

            result.close();

            if (lastID != -1) {
                statement.executeUpdate(
                        "DELETE FROM `" + DATABASE_NAME + "`.`" + table + "` WHERE `id` = '" + lastID + '\'');
            }

            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private final static void miningBoom() {
        try {
            System.out.println("Increasing GPU prices...\n");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + '/' + DATABASE_NAME, USERNAME,
                    PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery(
                            new String("SELECT * FROM `" + DATABASE_NAME + "`.`" + GPU_TABLE + "` ORDER BY `price`;"));

            ArrayList<Integer> ID = new ArrayList<Integer>();
            ArrayList<Double> prices = new ArrayList<Double>();

            while (result.next()) {
                ID.add(result.getInt("id"));
                prices.add(result.getDouble("price"));
            }

            result.close();

            for (int i = 0, size = ID.size(); i < size; ++i) {
                statement.executeUpdate(
                        new String("UPDATE `" + DATABASE_NAME + "`.`" + GPU_TABLE + "` SET `price` = '"
                                + Double.toString(prices.get(i) * 2.5) + "' WHERE `id` = '" + ID.get(i) + "';"));
            }

            statement.close();
            connection.close();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    public final static void main(final String[] args) {
        create();
        fill();
        print();
        popBack();
        print();
        miningBoom();
        printGPU();
    }
}
