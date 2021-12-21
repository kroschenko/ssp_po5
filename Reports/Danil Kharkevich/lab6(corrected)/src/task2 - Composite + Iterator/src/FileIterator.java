import java.util.ArrayList;
import java.util.List;

public class FileIterator implements AbstractFileIterator<BaseClass>{

    private List<BaseClass> files;
    private int position;

    public FileIterator(List<BaseClass> files) {
        this.files = files;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < files.size();
    }

    @Override
    public BaseClass next() {
        return files.get(position++);
    }

    @Override
    public BaseClass currentItem() {
        return files.get(position);
    }

    @Override
    public void reset() {
        position = 0;
    }


}
