class Decorator implements Level {

    protected Level mLevel;
    protected String mLevelName;

    public Decorator(Level level) {
        this.mLevel = level;
    }

    @Override
    public String getLevel() {
        return this.mLevel.getLevel();
    }

    @Override
    public String buyBook(String name) {
        return this.mLevel.buyBook(name);
    }

    @Override
    public String addToFavourites(String name) {
        return this.mLevel.addToFavourites(name);
    }

    @Override
    public String leaveMark(String name, String mark) {
        return this.mLevel.leaveMark(name, mark);
    }
}