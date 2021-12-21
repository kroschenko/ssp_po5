import java.text.SimpleDateFormat;
import java.util.Date;

class File extends BaseClass implements AbstractFile {

    public File(String name, Date dateOfCreate, float size, String type) {
        super(name, dateOfCreate, size, type);
    }

    public void ls() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(Main.compositeBuilder + name+ type + "   \t" + size + "Mb\t" + simpleDateFormat.format(dateOfCreate));
    }
}