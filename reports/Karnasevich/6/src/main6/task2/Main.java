package main6.task2;

import java.util.Arrays;


public final class Main {

    public static void main(String[] args) {
        var ivan = Employee.of("Ivan", Department.IT, 1000L);
        var liza = Employee.of("Liza", Department.IT, 1200L);
        var tuan = Employee.of("Tuan", Department.IT, 900L);
        var gray = Employee.of("Gray", Department.SALES, 800L);
        var soap = Employee.of("Soap", Department.SALES, 700L);
        var le = Employee.of("Le", Department.SALES, 900L);
        liza.assignManager(ivan);
        tuan.assignManager(liza);
        gray.assignManager(ivan);
        soap.assignManager(gray);
        le.assignManager(gray);
        var company = new Company(Arrays.asList(ivan, liza, tuan, gray, soap, le));
        company.pringSalaryReport();
    }
}
