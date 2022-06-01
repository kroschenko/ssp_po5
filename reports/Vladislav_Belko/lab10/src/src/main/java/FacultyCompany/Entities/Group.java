package FacultyCompany.Entities;

public class Group {
    private int id;
    private String groupname;

    public Group() {}

    public Group(String groupName) {
        this.groupname = groupName;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupName) {
        this.groupname = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return getGroupname();
    }

}
