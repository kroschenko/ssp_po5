package vmem;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class Master {
    public static final void main(final String[] args) throws Exception {
        final String FILENAME = new String(
                "C:\\Users\\User\\Desktop\\Handler.ser");
        final File FILE = new File(FILENAME);

        Handler handler = null;

        if (FILE.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(FILENAME);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                handler = (Handler) objectIn.readObject();
                System.out.println("Data deserialized from " + FILENAME + '.');

                objectIn.close();
                fileIn.close();

                handler.start();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            System.out.println("Getting ready your virtual memory pack...");

            final Long KB = 1024l, PACK_SIZE = KB * 1440l;

            handler = new Handler(PACK_SIZE);
            handler.start();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(handler);

            objectOut.close();
            fileOut.close();

            System.out.println("Data serialized in " + FILENAME + '.');
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
