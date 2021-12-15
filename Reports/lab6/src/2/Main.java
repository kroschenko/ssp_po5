class Task_2{
    public static void main(String[] args) {
        Client cl = new Client();
        System.out.println(cl.getLevel());
        System.out.println(cl.addToFavourites("book"));
        System.out.println(cl.leaveMark("book", "8"));

        cl.toSecondLevel();
        System.out.println(cl.getLevel());
        System.out.println(cl.addToFavourites("book"));
        System.out.println(cl.leaveMark("book", "8"));

        cl.toThirdLevel();
        System.out.println(cl.getLevel());
        System.out.println(cl.addToFavourites("book"));
        System.out.println(cl.leaveMark("book", "8"));
    }
}