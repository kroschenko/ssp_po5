package stct;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class Main {
    public static enum Speciality {
        MANAGER(0), ANALYST(1), PROGRAMMER(2), TESTER(3), DESIGNER(4), ACCOUNTANT(5);

        private static Map<Integer, Speciality> m_Map = new HashMap<Integer, Speciality>();

        static {
            for (final Speciality c_Speciality : Speciality.values()) {
                m_Map.put(c_Speciality.m_Index, c_Speciality);
            }
        }

        private Integer m_Index = 0;

        private Speciality(final Integer c_Index) {
            this.m_Index = c_Index;
        }

        public final static Speciality f_value_of(final Integer c_Speciality) {
            return (Speciality) m_Map.get(c_Speciality);
        }

        public final Integer f_get_value() {
            return this.m_Index;
        }
    }

    public final static Integer f_random_int(final Integer c_Min, final Integer c_Max) {
        Double result = (Math.random() * (c_Max - c_Min) + c_Min);
        return result.intValue();
    }

    public final static Double f_random_double(final Double c_Min, final Double c_Max) {
        return Math.random() * (c_Max - c_Min) + c_Min;
    }

    public final static void main(final String[] c_Args) throws Exception {
        Vector<String> v_Names = new Vector<String>();
        v_Names.add(new String("Maya Rogerson"));
        v_Names.add(new String("Liana Roy"));
        v_Names.add(new String("Liza Thomson"));
        v_Names.add(new String("Phoebe Teel"));
        v_Names.add(new String("Erika Herbertson"));
        v_Names.add(new String("Vicky Nixon"));
        v_Names.add(new String("Donelle Joiner"));
        v_Names.add(new String("Brynlee Alden"));
        v_Names.add(new String("Mae Isaacson"));
        v_Names.add(new String("Ocean Sharp"));
        v_Names.add(new String("Phil Stephenson"));
        v_Names.add(new String("Tilly Ellington"));
        v_Names.add(new String("Richmal Statham"));
        v_Names.add(new String("Margo Gadsby"));
        v_Names.add(new String("Trudie George"));
        v_Names.add(new String("Kortney Abbott"));
        v_Names.add(new String("Amery Lyon"));
        v_Names.add(new String("Brooklyn Knight "));

        final Integer c_NumberOfWorkers = v_Names.size(), c_NumberOfSpecialties = 6, c_MinAge = 18, c_MaxAge = 65;

        final Double c_MinimalSalary = 100.0, c_MinSalaryK = 1.0, c_MaxSalaryK = 2.0, c_ManagerMaxMinSalary = 1000.0,
                c_AnalystMaxMinSalary = 800.0, c_ProgrammerMaxMinSalary = 900.0, c_TesterMaxMinSalary = 500.0,
                c_DesignerMaxMinSalary = 700.0, c_AccountantMaxMinSalary = 450.0;

        Vector<Employee> v_Employees = new Vector<Employee>();

        for (Integer v_I = 0; v_I < c_NumberOfWorkers; ++v_I) {
            switch (Speciality.f_value_of(v_I % c_NumberOfSpecialties)) {
            case MANAGER:
                v_Employees.add(new Manager(f_random_int(c_MinAge, c_MaxAge), v_Names.elementAt(v_I),
                        f_random_double(c_MinimalSalary, c_ManagerMaxMinSalary),
                        f_random_double(c_MinSalaryK, c_MaxSalaryK)));
                break;
            case ANALYST:
                v_Employees.add(new Analyst(f_random_int(c_MinAge, c_MaxAge), v_Names.elementAt(v_I),
                        f_random_double(c_MinimalSalary, c_AnalystMaxMinSalary),
                        f_random_double(c_MinSalaryK, c_MaxSalaryK)));
                break;
            case PROGRAMMER:
                v_Employees.add(new Programmer(f_random_int(c_MinAge, c_MaxAge), v_Names.elementAt(v_I),
                        f_random_double(c_MinimalSalary, c_ProgrammerMaxMinSalary),
                        f_random_double(c_MinSalaryK, c_MaxSalaryK)));
                break;
            case TESTER:
                v_Employees.add(new Tester(f_random_int(c_MinAge, c_MaxAge), v_Names.elementAt(v_I),
                        f_random_double(c_MinimalSalary, c_TesterMaxMinSalary),
                        f_random_double(c_MinSalaryK, c_MaxSalaryK)));
                break;
            case DESIGNER:
                v_Employees.add(new Designer(f_random_int(c_MinAge, c_MaxAge), v_Names.elementAt(v_I),
                        f_random_double(c_MinimalSalary, c_DesignerMaxMinSalary),
                        f_random_double(c_MinSalaryK, c_MaxSalaryK)));
                break;
            case ACCOUNTANT:
                v_Employees.add(new Accountant(f_random_int(c_MinAge, c_MaxAge), v_Names.elementAt(v_I),
                        f_random_double(c_MinimalSalary, c_AccountantMaxMinSalary),
                        f_random_double(c_MinSalaryK, c_MaxSalaryK)));
                break;
            }

            v_Employees.elementAt(v_I).f_start_working();
        }

        for (Integer v_I = 0; v_I < c_NumberOfWorkers; ++v_I) {
            final Employee c_Employee = v_Employees.elementAt(v_I);

            c_Employee.f_work();

            System.out.println("Salary = " + c_Employee.f_get_minimal_salary() + " * " + c_Employee.f_get_salary_k()
                    + " = " + c_Employee.f_get_salary() + '\n');

        }
    }
}
