import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Directory extends BaseClass implements AbstractFile {
    private ArrayList<BaseClass> includedFiles = new ArrayList<>();

    public Directory(String name, Date dateOfCreate) {
        super(name, dateOfCreate, 0, "dir");
    }

    public void add(BaseClass obj) {
        includedFiles.add(obj);
        size += obj.size;
    }

    public void ls() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(Main.compositeBuilder + name + "  \t" + size + "Mb\t" + simpleDateFormat.format(dateOfCreate));
        Main.compositeBuilder.append("   ");
        for (BaseClass includedFile : includedFiles) includedFile.ls();
        Main.compositeBuilder.setLength(Main.compositeBuilder.length() - 3);
    }

    public ArrayList<BaseClass> getIncludedFiles() {
        ArrayList<BaseClass> files = new ArrayList<>();
        files.addAll(includedFiles);
        for (BaseClass b: includedFiles) {
            if (b.getClass() == Directory.class) {
                Directory dir = (Directory) b;
                files.addAll(dir.getIncludedFiles());
            }
        }
        return files;
    }
}