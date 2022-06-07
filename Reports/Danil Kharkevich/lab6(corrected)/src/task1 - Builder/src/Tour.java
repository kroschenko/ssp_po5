public class Tour {
    private int duration;

    private float transition;
    private float accomodation;
    private float meels;
    private float excursion;
    private float museum;
    private float theatre;

    private float cost;

    public float getCost() {
        return cost;
    }

    public static class Builder {
        private Tour newTour;

        public Builder() {
            newTour = new Tour();
            newTour.theatre = newTour.accomodation =
                    newTour.cost = newTour.excursion = newTour.meels =
                            newTour.transition = newTour.museum = 0;
            newTour.duration = 0;
        }

        public Builder setDuration(int duration) {
            newTour.duration = duration;
            return this;
        }

        public Builder byPlain() {
            newTour.transition = 30;
            return this;
        }

        public Builder byTrain() {
            newTour.transition = 20;
            return this;
        }

        public Builder byBus() {
            newTour.transition = 15;
            return this;
        }

        public Builder withAccomodation() {
            newTour.accomodation = newTour.duration * 5;
            return this;
        }

        public Builder withMeels() {
            newTour.meels = newTour.duration * 15;
            return this;
        }

        public Builder withExcursion() {
            newTour.excursion = 5;
            return this;
        }

        public Builder withTheatre() {
            newTour.theatre = 7;
            return this;
        }

        public Builder withMuseum() {
            newTour.museum = 3;
            return this;
        }

        public Tour build() {
            newTour.cost = newTour.excursion + newTour.theatre +
                    newTour.museum + newTour.meels + newTour.accomodation + newTour.transition;
            return newTour;
        }
    }
}
