package sector;

import java.util.Scanner;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        final Scanner c_Scanner = new Scanner(System.in);

        System.out.print("Enter window width: ");
        final Integer c_WindowWidth = c_Scanner.nextInt();

        System.out.print("Enter window height: ");
        final Integer c_WindowHeight = c_Scanner.nextInt();

        System.out.print("Enter sector length: ");
        final Integer c_SectorLength = c_Scanner.nextInt();

        c_Scanner.close();

        Sector v_SectorApp = new Sector(c_WindowWidth, c_WindowHeight, c_SectorLength);
        v_SectorApp.f_run();
    }
}
