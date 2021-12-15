class FingerprintScanner {
    private String version;

    public FingerprintScanner(String version){
        this.setScannerVersion(version);
    }

    public void setScannerVersion(String version) {
        this.version = version;
    }

    public String getScannerVersion() {
        return this.version;
    }
}