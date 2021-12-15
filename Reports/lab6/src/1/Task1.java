class Task_1{
    public static void main(String[] args) {
        Director director = new Director();

        SmartphoneBuilder builder = new SmartphoneBuilder();

        director.constructSmarthoneDAY(builder);

        Smartphone sm = builder.getResult();
        System.out.println(sm.print() + "\n");

        director.constructSmarthoneNIGHT(builder);

        sm = builder.getResult();
        System.out.println(sm.print() + "\n");

        director.constructSmarthoneSTAR(builder);

        sm = builder.getResult();
        System.out.println(sm.print() + "\n");
    }
}
