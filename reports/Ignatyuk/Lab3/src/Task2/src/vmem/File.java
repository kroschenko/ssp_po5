package vmem;

import net.sourceforge.sizeof.SizeOf;

public final class File extends Item {
    private String extension = null, content = null;

    public File(final String location, final String name, final String extension) {
        super(location, name, Item.Type.FILE);
        this.extension = new String(extension);
        this.content = new String();
    }

    public final String getExtension() {
        return new String(this.extension);
    }

    public final void setExtension(final String extension) {
        this.extension = new String(extension);
    }

    public final String getContent() {
        return new String(this.content);
    }

    public final void setContent(final String content) {
        this.content = new String(content);
    }

    public final void append(final String content) {
        this.content += new String(content);
    }

    @Override
    public final void printInfo() {
        System.out.println("f\t" + this.getLocation() + "\t" + this.getName() + "\t" + this.extension + "\t"
                + Long.toString(SizeOf.deepSizeOf(this)) + " bytes");
    }
}
