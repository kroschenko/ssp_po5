package vmem;

import java.util.Vector;

public final class Directory extends Item {
    private Vector<Item> content = null;

    public Directory(final String location, final String name) {
        super(location, name, Item.Type.DIRECTORY);
        this.content = new Vector<Item>();
    }

    public final Vector<Item> getContent() {
        return this.content;
    }

    @Override
    public final void printInfo() {
        System.out.println("d\t" + this.getLocation() + "\t" + this.getName() + "\t\t"
                + Integer.toString(this.content.size()) + " items");
    }
}
