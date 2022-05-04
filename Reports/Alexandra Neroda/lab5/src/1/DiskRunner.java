//interface Диск ← abstract class Директория ← class Файл.

public class DiskRunner {
    public static void main(String[] args) {
        File one = new File("Data", 239);
        File two = new File("Git", 25);
        one.info();
        two.info();
    }    
}

interface Disk {
    String getName();
    int getSize();
}

abstract class Dir implements Disk {
    private String name;
    private int size;
    
    public Dir(String name, int size) {
    
        this.name = name;
        this.size = size;
    }
  
    @Override
    public String getName() { return name; }

    @Override
    public int getSize() { return size; }

    public abstract void info();
}

class File extends Dir {

    public File(String name, int size) {
        super(name, size);
    }

    @Override
    public void info() {
        System.out.println("Filename: " + super.getName() + " || filesize: " + super.getSize());
    }

}