import java.util.ArrayList;
import java.util.List;

public class FilesList implements AbstaractFilesList<BaseClass> {
    private List<BaseClass> files = new ArrayList<>();

    public FilesList(Directory dir) {
        files.add(dir);
        files.addAll(dir.getIncludedFiles());
    }

    public AbstractFileIterator<BaseClass> iterator() {
        return new FileIterator(files);
    }
}
