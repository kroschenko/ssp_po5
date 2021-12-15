class FirstLevel implements Level {

    private String mLevelName;

    public FirstLevel() {
        this.mLevelName = "1";
    }

    @Override
    public String getLevel() {
        return this.mLevelName;
    }

    @Override
    public String buyBook(String name) {
        return name;
    }

    @Override
    public String addToFavourites(String name) {
        return "you cann't add to favourites on level 1.";
    }

    @Override
    public String leaveMark(String name, String mark) {
        return "you cann't leave mark on level 1.";
    }

}