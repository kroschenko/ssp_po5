class Client {
    private Level mClientLevel;

    Client() {
        this.mClientLevel = new FirstLevel();
    }

    public void toSecondLevel() {
        this.mClientLevel = new SecondLevel(this.mClientLevel);
    }

    public void toThirdLevel() {
        this.mClientLevel = new ThirdLevel(this.mClientLevel);
    }

    public String getLevel() {
        return this.mClientLevel.getLevel();
    }

    public String buyBook(String name) {
        return this.mClientLevel.buyBook(name);
    }

    public String addToFavourites(String name) {
        return this.mClientLevel.addToFavourites(name);
    }

    public String leaveMark(String name, String mark) {
        return this.mClientLevel.leaveMark(name, mark);
    }
}