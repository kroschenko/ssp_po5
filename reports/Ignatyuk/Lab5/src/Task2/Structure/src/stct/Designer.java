package stct;

public final class Designer extends Employee {
    public Designer(final Integer c_Age, final String c_Name, final Double c_MinimalSalary) {
        super(c_Age, c_Name, c_MinimalSalary);
    }

    public Designer(final Integer c_Age, final String c_Name, final Double c_MinimalSalary, final Double c_SalaryK) {
        super(c_Age, c_Name, c_MinimalSalary, c_SalaryK);
    }

    public final void f_work() {
        if (this.f_is_working()) {
            System.out.println("The designer " + this.f_get_name() + " is working...");
            return;
        }

        System.out.println("Designer " + this.f_get_name() + " does not work...");
    }
}
