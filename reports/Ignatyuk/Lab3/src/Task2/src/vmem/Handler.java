package vmem;

import java.util.Scanner;
import java.util.Vector;

import net.sourceforge.sizeof.SizeOf;

public final class Handler implements java.io.Serializable {
    private Long packSize = null;
    private Directory root = null, workingDirectory = null;
    private static Vector<Command> commands = null;

    private enum CommandType {
        LIST_ALL, CHANGE_DIRECTORY, WORKING_DIRECTORY, DISK_USAGE, MAKE_FILE, REMOVE_FILE, MAKE_DIR, REMOVE_DIR,
        FILL_FILE, PRINT_FILE, HELP, QUIT
    }

    static {
        Handler.commands = new Vector<Command>();
        Handler.commands.add(new Command(new String("la"), 1));
        Handler.commands.add(new Command(new String("cd"), 2));
        Handler.commands.add(new Command(new String("wd"), 1));
        Handler.commands.add(new Command(new String("du"), 1));
        Handler.commands.add(new Command(new String("mf"), 2));
        Handler.commands.add(new Command(new String("rf"), 2));
        Handler.commands.add(new Command(new String("md"), 2));
        Handler.commands.add(new Command(new String("rd"), 2));
        Handler.commands.add(new Command(new String("ff"), 3));
        Handler.commands.add(new Command(new String("pf"), 2));
        Handler.commands.add(new Command(new String("h"), 1));
        Handler.commands.add(new Command(new String("q"), 1));
    }

    public Handler(final Long packSize) {
        final String HOME = new String("/");

        this.packSize = packSize;
        this.root = new Directory(new String(HOME), new String(""));
        this.workingDirectory = this.root;

        System.out.println("[INFO]: Pack created, size = " + Long.toString(this.packSize) + " bytes.");
    }

    public final void start() {
        String answer = new String();
        String[] details = null;

        final Scanner SCANNER = new Scanner(System.in);
        this.printHelp();

        while (true) {
            System.out.print("> ");
            answer = SCANNER.nextLine();

            if (answer.isBlank()) {
                continue;
            }

            answer = answer.trim();
            details = answer.split("\\s+");

            boolean isFound = false;
            final Integer COMMAND_INDEX = 0;

            for (int i = 0, size = Handler.commands.size(); i < size; ++i) {
                if (!details[COMMAND_INDEX].toLowerCase()
                        .equals(Handler.commands.elementAt(i).getName().toLowerCase())) {
                    continue;
                }

                isFound = true;

                if (details.length != Handler.commands.elementAt(i).getParamsCount()) {
                    System.out.println(
                            "[ERROR]: Invalid parameters with \"" + details[COMMAND_INDEX] + "\" command! Must be "
                                    + Integer.toString(Handler.commands.elementAt(i).getParamsCount()) + '!');
                    break;
                }

                switch (CommandType.values()[i]) {
                    case LIST_ALL: {
                        this.listAll();
                        break;
                    }
                    case CHANGE_DIRECTORY: {
                        final Integer NAME_INDEX = 1;
                        final String UP_DIRECTORY = new String(".."), DIRNAME = new String(details[NAME_INDEX]);

                        if (DIRNAME.equals(UP_DIRECTORY)) {
                            final String SLASH = "/", HOME = new String(SLASH);

                            if (!this.getCurrentPath().equals(HOME)) {
                                String currentPath = this.getCurrentPath();

                                currentPath = new String(currentPath.substring(0, currentPath.lastIndexOf(SLASH)));

                                if (currentPath.equals(new String(""))) {
                                    currentPath = new String(HOME);
                                }

                                this.workingDirectory = this.getDirectoryByPath(currentPath);
                            }

                            break;
                        }

                        if (!this.changeDirectory(DIRNAME)) {
                            System.out
                                    .println("[ERROR]: The directory \'" + details[NAME_INDEX] + "\" does not exist!");
                        }

                        break;
                    }
                    case WORKING_DIRECTORY: {
                        System.out.println(this.getCurrentPath());
                        break;
                    }
                    case DISK_USAGE: {
                        this.printDiskUsage();
                        break;
                    }
                    case MAKE_FILE: {
                        final Integer NAME_INDEX = 1;
                        final Filename FILENAME = this.parseName(details[NAME_INDEX]);

                        if (FILENAME.getExtension().equals(new String(""))) {
                            System.out.println("[WARNING]: Creating a file without extension!");
                        }

                        if (!this.makeFile(FILENAME)) {
                            System.out.println("[ERROR]: The file \'" + details[NAME_INDEX]
                                    + "\" already exist or you do not have enough space!");
                        }

                        break;
                    }
                    case REMOVE_FILE: {
                        final Integer NAME_INDEX = 1;
                        final Filename FILENAME = this.parseName(details[NAME_INDEX]);

                        if (!this.removeFile(FILENAME)) {
                            System.out.println("[ERROR]: The file \'" + details[NAME_INDEX] + "\" does not exist!");
                        }

                        break;
                    }
                    case MAKE_DIR: {
                        final Integer NAME_INDEX = 1;

                        if (!this.makeDir(details[NAME_INDEX])) {
                            System.out.println("[ERROR]: The directory \'" + details[NAME_INDEX]
                                    + "\" already exist or you don't have enough space!");
                        }

                        break;
                    }
                    case REMOVE_DIR: {
                        final Integer NAME_INDEX = 1;

                        if (!this.removeDir(details[NAME_INDEX])) {
                            System.out
                                    .println("[ERROR]: The directory \'" + details[NAME_INDEX] + "\" does not exist!");
                            break;
                        }

                        break;
                    }
                    case FILL_FILE: {
                        final Integer NAME_INDEX = 1, CONTENT_INDEX = 2;
                        final Filename FILENAME = this.parseName(details[NAME_INDEX]);

                        if (!this.fillFile(FILENAME, details[CONTENT_INDEX])) {
                            System.out.println("[ERROR]: The file \'" + details[NAME_INDEX]
                                    + "\" does not exist or you don't have enough space!");
                        }

                        break;
                    }
                    case PRINT_FILE: {
                        final Integer NAME_INDEX = 1;
                        final Filename FILENAME = this.parseName(details[NAME_INDEX]);

                        if (!this.printFile(FILENAME)) {
                            System.out.println("[ERROR]: The file \'" + details[NAME_INDEX] + "\" does not exist!");
                        }

                        break;
                    }
                    case HELP: {
                        this.printHelp();
                        break;
                    }
                    case QUIT: {
                        SCANNER.close();
                        return;
                    }
                }

                break;
            }

            if (!isFound) {
                final Integer COMMANT_INDEX = 0;
                System.out.println("[ERROR]: Unknown command \"" + details[COMMANT_INDEX] + "\"!");
            }
        }
    }

    private final Long used() {
        return SizeOf.deepSizeOf(this.root);
    }

    private final Filename parseName(final String name) {
        final Integer DOT = name.lastIndexOf('.', name.length());
        String clearName = new String(name), extension = new String("");

        if (DOT != -1 && DOT != 0) {
            extension = name.substring(DOT, name.length());
            clearName = name.substring(0, DOT);
        }

        return new Filename(clearName, extension);
    }

    private final Boolean isFileExist(final Filename filename) {
        for (final Item item : this.workingDirectory.getContent()) {
            if (item.getType() == Item.Type.FILE && ((File) item).getName().equals(filename.getName())
                    && ((File) item).getExtension().equals(filename.getExtension())) {
                return true;
            }
        }

        return false;
    }

    private final Boolean isDirectoryExist(final String name) {
        for (final Item item : this.workingDirectory.getContent()) {
            if (item.getType() == Item.Type.DIRECTORY && ((Directory) item).getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    private final String getCurrentPath() {
        final String SLASH = new String("/");

        if (this.workingDirectory.getLocation().equals(SLASH)) {
            return new String(this.workingDirectory.getLocation() + this.workingDirectory.getName());
        }

        return new String(this.workingDirectory.getLocation() + SLASH + this.workingDirectory.getName());
    }

    private final Directory getDirectoryByPath(final String path) {
        final String SLASH = new String("/");
        final String[] DIRECTORIES = path.split(SLASH);

        Directory currentDirectory = root;
        Vector<Item> currentContent = this.root.getContent();

        for (int i = 1, size = DIRECTORIES.length; i < size; ++i) {
            for (final Item item : currentContent) {
                if (item.getType() == Item.Type.DIRECTORY && item.getName().equals(DIRECTORIES[i])) {
                    currentDirectory = (Directory) item;
                    currentContent = ((Directory) item).getContent();
                    break;
                }
            }
        }

        return currentDirectory;
    }

    private final Boolean changeDirectory(final String name) {
        for (final Item item : this.workingDirectory.getContent()) {
            if (item.getType() == Item.Type.DIRECTORY && ((Directory) item).getName().equals(name)) {
                final String SLASH = new String("/");
                String currentPath = this.getCurrentPath();

                if (!currentPath.endsWith(SLASH)) {
                    currentPath += SLASH;
                }

                currentPath = new String(currentPath + name);
                this.workingDirectory = this.getDirectoryByPath(currentPath);

                return true;
            }
        }

        return false;
    }

    private final void listAll() {
        for (final Item item : this.workingDirectory.getContent()) {
            item.printInfo();
        }
    }

    private final void printDiskUsage() {
        final Long USED = this.used(), FREE = this.packSize - USED;

        final Double PERCENT = 100.0, PERCENTAGE_USED = (double) USED * PERCENT / this.packSize,
                PERCENTAGE_FREE = (double) FREE * PERCENT / this.packSize;

        System.out.println("[INFO]: Storage (bytes): " + Long.toString(this.packSize));

        System.out.print("Used (bytes): " + Long.toString(USED) + "; Used (%): ");
        System.out.printf("%.2f\n", PERCENTAGE_USED);

        System.out.print("Free (bytes): " + Long.toString(FREE) + "; Used (%): ");
        System.out.printf("%.2f\n", PERCENTAGE_FREE);
    }

    private final Boolean makeFile(final Filename filename) {
        if (this.isFileExist(filename)) {
            return false;
        }

        final File NEW_FILE = new File(this.getCurrentPath(), filename.getName(), filename.getExtension());

        if (this.used() + SizeOf.deepSizeOf(NEW_FILE) > this.packSize) {
            return false;
        }

        this.workingDirectory.getContent().add(NEW_FILE);
        return true;
    }

    private final Boolean removeFile(final Filename filename) {
        for (int i = 0, size = this.workingDirectory.getContent().size(); i < size; ++i) {
            final Item ITEM = this.workingDirectory.getContent().elementAt(i);

            if (ITEM.getType() == Item.Type.FILE && ((File) ITEM).getName().equals(filename.getName())
                    && ((File) ITEM).getExtension().equals(filename.getExtension())) {
                this.workingDirectory.getContent().remove(i);
                return true;
            }
        }

        return false;
    }

    private final Boolean makeDir(final String name) {
        if (this.isDirectoryExist(name)) {
            return false;
        }

        final Directory NEW_DIRECTORY = new Directory(this.getCurrentPath(), name);

        if (this.used() + SizeOf.deepSizeOf(NEW_DIRECTORY) > this.packSize) {
            return false;
        }

        this.workingDirectory.getContent().add(NEW_DIRECTORY);
        return true;
    }

    private final Boolean removeDir(final String name) {
        for (int i = 0, size = this.workingDirectory.getContent().size(); i < size; ++i) {
            final Item ITEM = this.workingDirectory.getContent().elementAt(i);

            if (ITEM.getType() == Item.Type.DIRECTORY && ((Directory) ITEM).getName().equals(name)) {
                this.workingDirectory.getContent().remove(i);
                return true;
            }
        }

        return false;
    }

    private final Boolean fillFile(final Filename filename, final String content) {
        if (this.used() + SizeOf.deepSizeOf(content) > this.packSize) {
            return false;
        }

        for (final Item item : this.workingDirectory.getContent()) {
            if (item.getType() == Item.Type.FILE && ((File) item).getName().equals(filename.getName())
                    && ((File) item).getExtension().equals(filename.getExtension())) {
                ((File) item).append(content);
                return true;
            }
        }

        return false;
    }

    private final Boolean printFile(final Filename filename) {
        for (final Item item : this.workingDirectory.getContent()) {
            if (item.getType() == Item.Type.FILE && ((File) item).getName().equals(filename.getName())
                    && ((File) item).getExtension().equals(filename.getExtension())) {
                System.out.println(((File) item).getContent());
                return true;
            }
        }

        return false;
    }

    private final void printHelp() {
        System.out.println("[INFO]: You can use one of the following commands:");
        System.out.println("\tla\t\t\t-\tPrint all items in the working directory");
        System.out.println("\tcd [name]\t\t-\tChange working directory");
        System.out.println("\twd\t\t\t-\tPrint working directory");
        System.out.println("\tdu\t\t\t-\tPrint disk usage");
        System.out.println("\tmf [name]\t\t-\tMake new file");
        System.out.println("\trf [name]\t\t-\tRemove file");
        System.out.println("\tmd [name]\t\t-\tMake new directory");
        System.out.println("\trd [name]\t\t-\tRemove directory");
        System.out.println("\tff [name] [content]\t-\tFill the file with additional content");
        System.out.println("\tpf [name]\t\t-\tPrint file content");
        System.out.println("\th\t\t\t-\tPrint help message");
        System.out.println("\tq\t\t\t-\tQuit program");
    }
}
