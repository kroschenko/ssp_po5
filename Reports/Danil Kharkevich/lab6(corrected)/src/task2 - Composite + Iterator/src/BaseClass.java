import java.util.Date;

abstract class BaseClass implements AbstractFile {
    String name;
    Date dateOfCreate;
    float size;
    String type;

    public BaseClass(String name, Date dateOfCreate, float size, String type) {
        this.name = name;
        this.dateOfCreate = dateOfCreate;
        this.size = size;
        this.type = type;
    }

    public float getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public String getType() {
        return type;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
