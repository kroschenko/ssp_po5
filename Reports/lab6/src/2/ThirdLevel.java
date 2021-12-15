class ThirdLevel extends Decorator {

    public ThirdLevel(Level level) {
        super(level);
        this.mLevelName = "3->" + super.getLevel();
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
        return "you have left mark" + mark + " on book " + name + ".";
    }

}