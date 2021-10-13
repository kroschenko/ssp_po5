package vmem;

public final class Filename implements java.io.Serializable {
    private String name = null, extension = null;

    public Filename(final String name, final String extension) {
        this.name = new String(name);
        this.extension = new String(extension);
    }

    public final String getName() {
        return new String(this.name);
    }

    public final void setName(final String name) {
        this.name = new String(name);
    }

    public final String getExtension() {
        return new String(this.extension);
    }

    public final void setExtension(final String extension) {
        this.extension = new String(extension);
    }
}
