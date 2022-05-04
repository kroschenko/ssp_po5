package inner;

import java.util.HashSet;
import java.util.Set;

public final class Department {
    private String m_Name = new String();
    private Set<Department.Position> m_Positions = new HashSet<Department.Position>();

    public Department() {
    }

    public Department(final String c_Name) {
        this.m_Name = c_Name;
    }

    public Department(final String c_Name, final Set<Department.Position> c_Positions) {
        this.m_Name = c_Name;
        this.m_Positions = c_Positions;
    }

    public final void f_set_name(final String c_Name) {
        this.m_Name = c_Name;
    }

    public final String f_get_name() {
        return this.m_Name;
    }

    public final void f_set_positions(final Set<Department.Position> c_Positions) {
        this.m_Positions = c_Positions;
    }

    public final Set<Department.Position> f_get_positions() {
        return this.m_Positions;
    }

    public final void f_add_position(final Department.Position c_Position) {
        this.m_Positions.add(c_Position);
    }

    public final void f_remove_position(final Department.Position c_Position) {
        this.m_Positions.remove(c_Position);
    }

    public final static class Position {
        private String m_Name = new String();
        private Set<Position.Employee> m_Employees = new HashSet<Position.Employee>();

        public Position() {
        }

        public Position(final String c_Name) {
            this.m_Name = c_Name;
        }

        public Position(final String c_Name, final Set<Position.Employee> c_Employees) {
            this.m_Name = c_Name;
            this.m_Employees = c_Employees;
        }

        public final void f_set_name(final String c_Name) {
            this.m_Name = c_Name;
        }

        public final String f_get_name() {
            return this.m_Name;
        }

        public final void f_set_employees(final Set<Position.Employee> c_Employees) {
            this.m_Employees = c_Employees;
        }

        public final Set<Position.Employee> f_get_employees() {
            return this.m_Employees;
        }

        public final void f_add_employee(final Position.Employee c_Employee) {
            this.m_Employees.add(c_Employee);
        }

        public final void f_remove_employee(final Position.Employee c_Employee) {
            this.m_Employees.remove(c_Employee);
        }

        public final static class Employee {
            private Integer m_Age;
            private String m_Name = new String();

            public Employee(final Integer c_Age, final String c_Name) {
                this.m_Age = c_Age;
                this.m_Name = c_Name;
            }

            public final void f_set_age(final Integer c_Age) {
                this.m_Age = c_Age;
            }

            public final Integer f_get_age() {
                return this.m_Age;
            }

            public final void f_set_name(final String c_Name) {
                this.m_Name = c_Name;
            }

            public final String f_get_name() {
                return this.m_Name;
            }
        }
    }
}
