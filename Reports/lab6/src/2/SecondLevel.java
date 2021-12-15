class SecondLevel extends Decorator {

    public SecondLevel(Level level) {
        super(level);
        this.mLevelName = "2->" + super.getLevel();
    }

    @Override
    public String getLevel() {
        return this.mLevelName;
    }

    @Override
    public String buyBook(String name) {
        return this.mLevel.buyBook(name);
    }

    @Override
    public String addToFavourites(String name) {
        return "you have added book " + name + " to favourites.";
    }

    @Override
    public String leaveMark(String name, String mark) {
        return "you cann't leave mark on level 2.";
    }
}