package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DB {
    private final static String DATABASE_NAME = "lab";
    public final static String CUSTOMERS_TABLE = "customers";
    public final static String WORKERS_TABLE = "workers";
    public final static String CPU_TABLE = "cpu";
    public final static String GPU_TABLE = "gpu";
    public final static String ORDERS_TABLE = "orders";

    private Connection connection = null;

    public DB() {
        try {
            final String HOST = "localhost";
            final String PORT = "3307";
            final String USERNAME = "root";
            final String PASSWORD = "secret";
            final String URL = "jdbc:mysql://" + HOST + ':' + PORT;

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL + "/?user=" + USERNAME + "&password=" + PASSWORD);
            this.prepare();
            // this.fill();
        } catch (final ClassNotFoundException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
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
                            + DB.CUSTOMERS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(64) NOT NULL , "
                            + "`last_name` VARCHAR(64) NOT NULL , `email` VARCHAR(64) NOT NULL , PRIMARY KEY (`id`) , "
                            + "UNIQUE (`email`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`"
                            + DB.WORKERS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(64) NOT NULL , "
                            + "`last_name` VARCHAR(64) NOT NULL , `email` VARCHAR(64) NOT NULL , `position` VARCHAR(64) NOT NULL , "
                            + "PRIMARY KEY (`id`) , UNIQUE (`email`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`" +
                            DB.CPU_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`price` DOUBLE UNSIGNED NOT NULL , `description` TEXT NULL , PRIMARY KEY (`id`) , UNIQUE (`name`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`" +
                            DB.GPU_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `name` VARCHAR(64) NOT NULL , "
                            + "`price` DOUBLE UNSIGNED NOT NULL , `description` TEXT NULL , PRIMARY KEY (`id`) , UNIQUE (`name`) ) ENGINE = InnoDB;"),
                    new String("CREATE TABLE IF NOT EXISTS `" + DB.DATABASE_NAME + "`.`" +
                            DB.ORDERS_TABLE
                            + "` ( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `customer_id` INT UNSIGNED NOT NULL , "
                            + "`worker_id` INT UNSIGNED NOT NULL , `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , "
                            + "`price` DOUBLE UNSIGNED NOT NULL, `cpu_id` INT UNSIGNED NOT NULL , `gpu_id` INT UNSIGNED NOT NULL , "
                            + "PRIMARY KEY (`id`) , INDEX `customer_id_index` (`customer_id`) , INDEX `worker_id_index` (`worker_id`) , "
                            + "INDEX `cpu_id_index` (`cpu_id`) , INDEX `gpu_id_index` (`gpu_id`) ) ENGINE = InnoDB;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `customer_id` ) REFERENCES `"
                            + DB.CUSTOMERS_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `worker_id` ) REFERENCES `"
                            + DB.WORKERS_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `cpu_id` ) REFERENCES `" + DB.CPU_TABLE
                            + "` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT ;"),
                    new String("ALTER TABLE `" + DB.DATABASE_NAME + "`.`" + DB.ORDERS_TABLE
                            + "` ADD FOREIGN KEY ( `gpu_id` ) REFERENCES `" + DB.GPU_TABLE
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

    public final ResultSet getOrders(final String customerFilter, final String workerFilter, final Integer id) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            String sql = new String("SELECT "
                    + "`orders`.`id` , "
                    + "`customers`.`email` AS `customer` , "
                    + "`workers`.`email` AS `worker` , "
                    + "`orders`.`date` , "
                    + "`orders`.`price` , "
                    + "`cpu`.`name` AS `cpu` , "
                    + "`gpu`.`name` AS `gpu` "
                    + "FROM `orders` "
                    + "INNER JOIN `customers` ON `orders`.`customer_id` = `customers`.`id` "
                    + "INNER JOIN `workers` ON `orders`.`worker_id` = `workers`.`id` "
                    + "INNER JOIN `cpu` ON `orders`.`cpu_id` = `cpu`.`id` "
                    + "INNER JOIN `gpu` ON `orders`.`gpu_id` = `gpu`.`id`");

            if (id != null) {
                sql += " WHERE `orders`.`id` = '" + Integer.toString(id) + "';";
                return statement.executeQuery(sql);
            }

            if (customerFilter != null && workerFilter != null) {
                sql += " WHERE `customers`.`email` = '" + customerFilter + "' AND `workers`.`email` = '" + workerFilter
                        + "';";
                return statement.executeQuery(sql);
            }

            if (customerFilter != null) {
                sql += " WHERE `customers`.`email` = '" + customerFilter + "';";
                return statement.executeQuery(sql);
            }

            if (workerFilter != null) {
                sql += " WHERE `workers`.`email` = '" + workerFilter + "';";
                return statement.executeQuery(sql);
            }

            return statement.executeQuery(sql + ';');
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }

        return null;
    }

    public final ResultSet getOrderDetails(final Integer id) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            return statement
                    .executeQuery(new String("SELECT "
                            + "`customers`.`first_name` AS `customer_first_name` , "
                            + "`customers`.`last_name` AS `customer_last_name` , "
                            + "`workers`.`first_name` AS `worker_first_name` , "
                            + "`workers`.`last_name` AS `worker_last_name` , "
                            + "`workers`.`position` AS `worker_position` , "
                            + "`cpu`.`price` AS `cpu_price` , "
                            + "`cpu`.`description` AS `cpu_description` , "
                            + "`gpu`.`price` AS `gpu_price` , "
                            + "`gpu`.`description` AS `gpu_description` "
                            + "FROM `orders` "
                            + "INNER JOIN `customers` ON `orders`.`customer_id` = `customers`.`id` "
                            + "INNER JOIN `workers` ON `orders`.`worker_id` = `workers`.`id` "
                            + "INNER JOIN `cpu` ON `orders`.`cpu_id` = `cpu`.`id` "
                            + "INNER JOIN `gpu` ON `orders`.`gpu_id` = `gpu`.`id` "
                            + "WHERE `orders`.`id` = '" + Integer.toString(id) + "';"));
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

    public final void addOrder(final Order order) {
        try {
            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();
            ResultSet resultSet = null;

            resultSet = statement.executeQuery(
                    "SELECT `customers`.`id` FROM `customers` WHERE `email` = '" + order.getCustomer() + "';");
            resultSet.next();
            Integer customerId = resultSet.getInt("id");

            resultSet = statement
                    .executeQuery("SELECT `workers`.`id` FROM `workers` WHERE `email` = '" + order.getWorker() + "';");
            resultSet.next();
            Integer workerId = resultSet.getInt("id");

            resultSet = statement
                    .executeQuery("SELECT `cpu`.`price` FROM `cpu` WHERE `name` = '" + order.getCpu() + "';");
            resultSet.next();
            Double cpuPrice = resultSet.getDouble("price");

            resultSet = statement
                    .executeQuery("SELECT `gpu`.`price` FROM `gpu` WHERE `name` = '" + order.getGpu() + "';");
            resultSet.next();
            Double gpuPrice = resultSet.getDouble("price");

            resultSet = statement.executeQuery("SELECT `cpu`.`id` FROM `cpu` WHERE `name` = '" + order.getCpu() + "';");
            resultSet.next();
            Integer cpuId = resultSet.getInt("id");

            resultSet = statement.executeQuery("SELECT `gpu`.`id` FROM `gpu` WHERE `name` = '" + order.getGpu() + "';");
            resultSet.next();
            Integer gpuId = resultSet.getInt("id");

            String query = null;

            if (order.getId() == null) {
                query = new String("INSERT INTO `" + DB.ORDERS_TABLE
                        + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                        + "VALUES (NULL, '" + customerId + "', '" + workerId + "', current_timestamp(), "
                        + Double.toString(cpuPrice + gpuPrice) + ", '" + Integer.toString(cpuId) + "', '"
                        + Integer.toString(gpuId) + "');");

                statement.executeUpdate(query);
                return;
            }

            query = new String("UPDATE `" + DB.ORDERS_TABLE + "` SET "
                    + "`customer_id` = '" + Integer.toString(customerId)
                    + "' , `worker_id` = '" + Integer.toString(workerId)
                    + "' , `date` = current_timestamp() , "
                    + "`price` = '" + Double.toString(cpuPrice + gpuPrice)
                    + "' , `cpu_id` = '" + Integer.toString(cpuId)
                    + "' , `gpu_id` = '" + Integer.toString(gpuId)
                    + "' WHERE `orders`.`id` = '" + Integer.toString(order.getId()) + "';");

            statement.executeUpdate(query);
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fill() {
        this.fillCustomers();
        this.fillWorkers();
        this.fillCpu();
        this.fillGpu();
        this.fillOrders();
    }

    private final void fillCustomers() {
        try {
            String[] customers = {
                    new String("INSERT INTO `" + DB.CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Gale', 'Bean', 'Gale_Bean@gmail.com');"),
                    new String("INSERT INTO `" + DB.CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Abel', 'Wood', 'Abel_Wood@gmail.com');"),
                    new String("INSERT INTO `" + DB.CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Roosevelt', 'Glover', 'Roosevelt_Glover@gmail.com');"),
                    new String("INSERT INTO `" + DB.CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Avery', 'Schaefer', 'Avery_Schaefer@gmail.com');"),
                    new String("INSERT INTO `" + DB.CUSTOMERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`) VALUES (NULL, 'Terry', 'Duffy', 'Terry_Duffy@gmail.com');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : customers) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillWorkers() {
        try {
            String[] workers = {
                    new String("INSERT INTO `" + DB.WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Lilac', 'Rick', 'Lilac_Rick@gmail.com', 'junior');"),
                    new String("INSERT INTO `" + DB.WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Abilene', 'Debra', 'Abilene_Debra@gmail.com', 'senior');"),
                    new String("INSERT INTO `" + DB.WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Caroline', 'Jean', 'Caroline_Jean@gmail.com', 'junior');"),
                    new String("INSERT INTO `" + DB.WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Kiki', 'Gene', 'Kiki_Gene@gmail.com', 'middle');"),
                    new String("INSERT INTO `" + DB.WORKERS_TABLE
                            + "` (`id`, `first_name`, `last_name`, `email`, `position`) VALUES (NULL, 'Joanie', 'Julianne', 'Joanie_Julianne@gmail.com', 'middle');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : workers) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillCpu() {
        try {
            String[] cpu = {
                    new String("INSERT INTO `" + DB.CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Ryzen 3 4100', 99.00, "
                            + "'The AMD Ryzen 3 4100 is a desktop processor with 4 cores, launched in April 2022. "
                            + "It is part of the Ryzen 3 lineup, using the Zen 2 (Renoir) architecture with Socket AM4.');"),
                    new String("INSERT INTO `" + DB.CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Ryzen 7 5800X3D', 449.00, "
                            + "'The AMD Ryzen 7 5800X3D is a desktop processor with 8 cores, launched in April 2022. "
                            + "It is part of the Ryzen 7 lineup, using the Zen 3 (Vermeer) architecture with Socket AM4.');"),
                    new String("INSERT INTO `" + DB.CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD FX-6300', 132.00, 'The AMD FX-6300 was "
                            + "a desktop processor with 6 cores, launched in October 2012. It is part of the FX lineup, using the "
                            + "Vishera architecture with Socket AM3+. FX-6300 has 8MB of L3 cache and operates at 3.5 GHz by default, "
                            + "but can boost up to 4.1 GHz, depending on the workload.');"),
                    new String("INSERT INTO `" + DB.CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'Intel Core i5-10400F', 220.00, "
                            + "'The Intel Core i5-10400F is a desktop processor with 6 cores, launched in April 2020. It is part "
                            + "of the Core i5 lineup, using the Comet Lake architecture with Socket 1200. Thanks to Intel "
                            + "Hyper-Threading the core-count is effectively doubled, to 12 threads. Core i5-10400F has 12MB of L3 cache "
                            + "and operates at 2.9 GHz by default, but can boost up to 4.3 GHz.');"),
                    new String("INSERT INTO `" + DB.CPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'Intel Core i9-12900K', 599.00, "
                            + "'The Intel Core i9-12900K is a desktop processor with 16 cores, launched in November 2021. "
                            + "It is part of the Core i9 lineup, using the Alder Lake-S architecture with Socket 1700. Thanks "
                            + "to Intel Hyper-Threading the core-count is effectively doubled, to 24 threads. Core i9-12900K has "
                            + "30MB of L3 cache and operates at 3.2 GHz by default, but can boost up to 5.2 GHz.');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : cpu) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillGpu() {
        try {
            String[] gpu = {
                    new String("INSERT INTO `" + DB.GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'NVIDIA GeForce RTX 3060', 329.00, "
                            + "'The GeForce RTX 3060 is a performance-segment graphics card by NVIDIA, launched on January 12th, 2021. "
                            + "Built on the 8 nm process, and based on the GA106 graphics processor, in its GA106-300-A1 variant, "
                            + "the card supports DirectX 12 Ultimate.');"),
                    new String("INSERT INTO `" + DB.GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Radeon RX 6600 XT', 379.00, "
                            + "'The Radeon RX 6600 XT is a performance-segment graphics card by AMD, launched on July 30th, 2021. "
                            + "Built on the 7 nm process, and based on the Navi 23 graphics processor, in its Navi 23 XT variant, "
                            + "the card supports DirectX 12 Ultimate.');"),
                    new String("INSERT INTO `" + DB.GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'NVIDIA GeForce GTX 1060 6 GB', 299.00, "
                            + "'The GeForce GTX 1060 6 GB was a performance-segment graphics card by NVIDIA, launched on July 19th, 2016. "
                            + "Built on the 16 nm process, and based on the GP106 graphics processor, in its GP106-400-A1 variant, "
                            + "the card supports DirectX 12.');"),
                    new String("INSERT INTO `" + DB.GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'AMD Radeon RX 6700 XT', 479.00, "
                            + "'The Radeon RX 6700 XT is a high-end graphics card by AMD, launched on March 3rd, 2021. "
                            + "Built on the 7 nm process, and based on the Navi 22 graphics processor, in its Navi 22 XT variant, "
                            + "the card supports DirectX 12 Ultimate.');"),
                    new String("INSERT INTO `" + DB.GPU_TABLE
                            + "` (`id`, `name`, `price`, `description`) VALUES (NULL, 'NVIDIA GeForce GTX 1080', 599.00, "
                            + "'The GeForce GTX 1080 was a high-end graphics card by NVIDIA, launched on May 27th, 2016. "
                            + "Built on the 16 nm process, and based on the GP104 graphics processor, in its GP104-400-A1 variant, "
                            + "the card supports DirectX 12.');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : gpu) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private final void fillOrders() {
        try {
            String[] orders = {
                    new String("INSERT INTO `" + DB.ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '3', '2', current_timestamp(), 549.00, '4', '1');"),
                    new String("INSERT INTO `" + DB.ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '5', '1', current_timestamp(), 748.00, '2', '3');"),
                    new String("INSERT INTO `" + DB.ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '4', '5', current_timestamp(), 478.00, '1', '2');"),
                    new String("INSERT INTO `" + DB.ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '2', '3', current_timestamp(), 1078.00, '5', '4');"),
                    new String("INSERT INTO `" + DB.ORDERS_TABLE
                            + "` (`id`, `customer_id`, `worker_id`, `date`, `price`, `cpu_id`, `gpu_id`) "
                            + "VALUES (NULL, '1', '4', current_timestamp(), 731.00, '3', '5');")
            };

            Statement statement = this.connection.createStatement();
            statement.closeOnCompletion();

            for (final String sql : orders) {
                statement.executeUpdate(sql);
            }
        } catch (final SQLException exception) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
