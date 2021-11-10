package inner;

import java.util.HashSet;
import java.util.Set;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        Department.Position.Employee v_Lilah = new Department.Position.Employee(21, "Lilah Boon"),
                v_Ethan = new Department.Position.Employee(21, "Ethan Brand"),
                v_Teri = new Department.Position.Employee(28, "Teri Parish"),
                v_Morty = new Department.Position.Employee(19, "Morty Pond"),
                v_Karyn = new Department.Position.Employee(24, "Karyn Scrivens"),
                v_Jeffrey = new Department.Position.Employee(22, "Jeffrey Fairbairn"),
                v_Zara = new Department.Position.Employee(29, "Zara Vernon"),
                v_Jolene = new Department.Position.Employee(32, "Jolene Moon"),
                v_Sharalyn = new Department.Position.Employee(25, "Sharalyn Lowe");

        Department.Position v_Marketer = new Department.Position("Marketer"),
                v_BusinessAnalyst = new Department.Position("Business Analyst"),
                v_SalesManager = new Department.Position("Sales Manager");

        v_Marketer.f_add_employee(v_Lilah);
        v_Marketer.f_add_employee(v_Ethan);
        v_Marketer.f_add_employee(v_Teri);

        v_BusinessAnalyst.f_add_employee(v_Morty);
        v_BusinessAnalyst.f_add_employee(v_Karyn);
        v_BusinessAnalyst.f_add_employee(v_Jeffrey);

        v_SalesManager.f_add_employee(v_Zara);
        v_SalesManager.f_add_employee(v_Jolene);
        v_SalesManager.f_add_employee(v_Sharalyn);

        Set<Department.Position> v_SalesPositions = new HashSet<Department.Position>();
        v_SalesPositions.add(v_Marketer);
        v_SalesPositions.add(v_BusinessAnalyst);
        v_SalesPositions.add(v_SalesManager);

        Department v_Sales = new Department(new String("Sales Department"));
        v_Sales.f_set_positions(v_SalesPositions);

        System.out.println(v_Sales.f_get_name() + new String(":"));

        for (final Department.Position c_Position : v_Sales.f_get_positions()) {
            System.out.println(new String("\t") + c_Position.f_get_name() + new String(":"));

            for (final Department.Position.Employee c_Employee : c_Position.f_get_employees()) {
                System.out.println(new String("\t\t") + c_Employee.f_get_name());
            }

            System.out.println();
        }

        ///

        Department.Position.Employee v_Brand = new Department.Position.Employee(28, "Brand Ash"),
                v_Ariella = new Department.Position.Employee(20, "Ariella Evered"),
                v_Kenneth = new Department.Position.Employee(20, "Kenneth Stafford"),
                v_Blaze = new Department.Position.Employee(24, "Blaze Wilton"),
                v_Camryn = new Department.Position.Employee(33, "Camryn Kingston"),
                v_Ford = new Department.Position.Employee(26, "Ford Lamb"),
                v_Dorinda = new Department.Position.Employee(18, "Dorinda Constable"),
                v_Francis = new Department.Position.Employee(36, "Francis Bray"),
                v_Peace = new Department.Position.Employee(31, "Peace Morris");

        Department.Position v_Administrator = new Department.Position("Administrator"),
                v_Programmer = new Department.Position("Programmer"),
                v_SecuritySpecialist = new Department.Position("Security Specialist");

        v_Administrator.f_add_employee(v_Brand);
        v_Administrator.f_add_employee(v_Ariella);
        v_Administrator.f_add_employee(v_Kenneth);

        v_Programmer.f_add_employee(v_Blaze);
        v_Programmer.f_add_employee(v_Camryn);
        v_Programmer.f_add_employee(v_Ford);

        v_SecuritySpecialist.f_add_employee(v_Dorinda);
        v_SecuritySpecialist.f_add_employee(v_Francis);
        v_SecuritySpecialist.f_add_employee(v_Peace);

        Department v_IT = new Department(new String("IT Department"));
        v_IT.f_add_position(v_Administrator);
        v_IT.f_add_position(v_Programmer);
        v_IT.f_add_position(v_SecuritySpecialist);

        System.out.println(v_IT.f_get_name() + new String(":"));

        for (final Department.Position c_Position : v_IT.f_get_positions()) {
            System.out.println(new String("\t") + c_Position.f_get_name() + new String(":"));

            for (final Department.Position.Employee c_Employee : c_Position.f_get_employees()) {
                System.out.println(new String("\t\t") + c_Employee.f_get_name());
            }

            System.out.println();
        }
    }
}
