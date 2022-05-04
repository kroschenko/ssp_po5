package stct;

public abstract class Employee extends Person {
    private Boolean m_IsWorking = Boolean.FALSE;
    private Double m_MinimalSalary = 0.0, m_SalaryK = 1.0, m_Salary = 0.0;

    public Employee(final Integer c_Age, final String c_Name, final Double c_MinimalSalary) {
        super(c_Age, c_Name);
        this.m_MinimalSalary = c_MinimalSalary;
        this.m_Salary = this.m_MinimalSalary * this.m_SalaryK;
    }

    public Employee(final Integer c_Age, final String c_Name, final Double c_MinimalSalary, final Double c_SalaryK) {
        super(c_Age, c_Name);
        this.m_MinimalSalary = c_MinimalSalary;
        this.m_SalaryK = c_SalaryK;
        this.m_Salary = this.m_MinimalSalary * this.m_SalaryK;
    }

    public final void f_start_working() {
        this.m_IsWorking = Boolean.TRUE;
    }

    public final void f_stop_working() {
        this.m_IsWorking = Boolean.FALSE;
    }

    public final Boolean f_is_working() {
        return this.m_IsWorking;
    }

    public final void f_set_minimal_salary(final Double c_MinimalSalary) {
        this.m_MinimalSalary = c_MinimalSalary;
        this.m_Salary = this.m_MinimalSalary * this.m_SalaryK;
    }

    public final Double f_get_minimal_salary() {
        return this.m_MinimalSalary;
    }

    public final void f_set_salary_k(final Double c_SalaryK) {
        this.m_SalaryK = c_SalaryK;
        this.m_Salary = this.m_MinimalSalary * this.m_SalaryK;
    }

    public final Double f_get_salary_k() {
        return this.m_SalaryK;
    }

    public final Double f_get_salary() {
        return this.m_Salary;
    }

    public abstract void f_work();
}
