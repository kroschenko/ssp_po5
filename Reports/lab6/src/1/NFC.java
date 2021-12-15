class NFC {
    private String version;

    public NFC(String version){
        this.setNFCVersion(version);
    }

    public void setNFCVersion(String version) {
        this.version = version;
    }

    public String getNFCVersion() {
        return this.version;
    }
}