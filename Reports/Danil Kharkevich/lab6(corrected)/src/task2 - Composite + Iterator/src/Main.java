import java.util.Date;

public class Main {

    public static StringBuffer compositeBuilder = new StringBuffer();

    public static void main(String[] args) {
        Directory music = new Directory("MUSIC", new Date());
        Directory beyonce = new Directory("Beyonce", new Date());
        Directory pop = new Directory("Pop", new Date());

        File file1 = new File("Kids", new Date(), (float)15.5, ".mp3");
        File file2 = new File("Teenage Dream", new Date(), (float)12.5, ".mp3");
        File file3 = new File("Flawless", new Date(), (float)18.2, ".mp3");
        File file4 = new File("Halo", new Date(), (float)10.1, ".mp3");

        music.add(file1);
        music.add(pop);
        pop.add(beyonce);
        beyonce.add(file3);
        beyonce.add(file4);
        pop.add(file2);

        music.ls();

        AbstaractFilesList<BaseClass> filesList = new FilesList(music);
        AbstractFileIterator<BaseClass> iterator = filesList.iterator();

        System.out.println('\n');
        while(iterator.hasNext()) {
            BaseClass cur = iterator.next();
            System.out.println(cur.getName() + '\t' + cur.getSize() + " Mb");
        }

    }
}
