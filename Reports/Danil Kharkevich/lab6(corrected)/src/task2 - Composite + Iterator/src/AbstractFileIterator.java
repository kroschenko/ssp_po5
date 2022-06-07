public interface AbstractFileIterator<BaseClass> {
    boolean hasNext();
    BaseClass next();
    BaseClass currentItem();
    void reset();

}
