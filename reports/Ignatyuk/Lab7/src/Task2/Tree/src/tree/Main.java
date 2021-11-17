package tree;

import java.util.Scanner;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        final Scanner c_Scanner = new Scanner(System.in);

        System.out.print("Enter window width: ");
        final Integer c_WindowWidth = c_Scanner.nextInt();

        System.out.print("Enter window height: ");
        final Integer c_WindowHeight = c_Scanner.nextInt();

        System.out.print("Enter tree root length: ");
        final Integer c_RootLength = c_Scanner.nextInt();

        System.out.print("Enter recursion depth: ");
        final Integer c_Depth = c_Scanner.nextInt();

        System.out.print("Enter tree length K: ");
        final Double c_LengthK = c_Scanner.nextDouble();

        System.out.print("Enter tree right fall: ");
        final Double c_RightFall = c_Scanner.nextDouble();

        System.out.print("Enter tree left fall: ");
        final Double c_LeftFall = c_Scanner.nextDouble();

        c_Scanner.close();

        Tree v_TreeApp = new Tree(c_WindowWidth, c_WindowHeight, c_RootLength, c_Depth, c_LengthK, c_RightFall,
                c_LeftFall);
        v_TreeApp.f_run();
    }
}
