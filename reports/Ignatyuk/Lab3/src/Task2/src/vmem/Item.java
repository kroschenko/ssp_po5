package vmem;

public abstract class Item implements java.io.Serializable {
    public static enum Type {
        FILE, DIRECTORY
    }

    private String location = null, name = null;
    private Item.Type type = null;

    protected Item(final String location, final String name, final Item.Type type) {
        this.location = new String(location);
        this.name = new String(name);
        this.type = type;
    }

    protected final String getName() {
        return new String(this.name);
    }

    protected final void setName(final String name) {
        this.name = new String(name);
    }

    protected final Item.Type getType() {
        return this.type;
    }

    protected final String getLocation() {
        return new String(this.location);
    }

    protected abstract void printInfo();
}
