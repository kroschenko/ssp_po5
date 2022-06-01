package FacultyCompany.Entities;

public class Teacher {
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;

    public Teacher() {}

    public Teacher(String firstName, String lastName, String patronymic) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString()
    {
        return getFirstname() + " " + getLastname();
    }

}
