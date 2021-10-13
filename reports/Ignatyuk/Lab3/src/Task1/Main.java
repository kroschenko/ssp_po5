public final class Main {
    public static final void main(String[] args) throws Exception {
        Set set_1 = new Set(3, new Integer[] {});
        set_1.print();

        set_1.add(5);
        set_1.add(5);
        set_1.add(0);
        set_1.add(7);
        set_1.add(8);
        set_1.print();

        set_1.remove(7);
        set_1.print();

        Set set_2 = new Set(6, new Integer[] { 3, 6, 7, 3, 9, 2 });
        set_2.print();

        Set set_3 = new Set(5, new Integer[] { 4, 3, 8, 1, 7 });
        set_3.print();

        if (set_2.equals(set_3)) {
            System.out.println("set_2 is equal to set_3");
        } else {
            System.out.println("set_2 is not equal to set_3");
        }

        Set set_4 = new Set(8, new Integer[] {});
        set_4.join(set_1);
        set_4.join(set_2);
        set_4.join(set_3);
        set_4.print();
    }
}
