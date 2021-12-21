public class Main {

    public static void main(String[] args) {
        Tour tour1 = new Tour.Builder()
                .setDuration(3)
                .byBus()
                .withAccomodation()
                .withMeels()
                .withMuseum()
                .build();
        Tour tour2 = new Tour.Builder()
                .setDuration(2)
                .byPlain()
                .withAccomodation()
                .withTheatre()
                .withMuseum()
                .withExcursion()
                .build();
        Tour tour3 = new Tour.Builder()
                .setDuration(5)
                .byTrain()
                .withAccomodation()
                .withMeels()
                .withMuseum()
                .withExcursion()
                .withTheatre()
                .build();
        System.out.println("Tour 1: " + tour1.getCost() + "\nTour 2: " + tour2.getCost() + "\nTour 3: " + tour3.getCost());
    }
}
