public class Director {

    public void constructSmarthoneDAY(Builder builder) {
        builder.setSmartphoneType(SmartphoneType.SMARTPHONE_DAY);
        builder.setColor(new Color("white"));
        builder.setName("DAY");
        builder.setNFC(new NFC("4.1"));
    }

    public void constructSmarthoneNIGHT(Builder builder) {
        builder.setSmartphoneType(SmartphoneType.SMARTPHONE_NIGHT);
        builder.setColor(new Color("black"));
        builder.setName("NIGHT");
        builder.setFingerprintScanner(new FingerprintScanner("8.9"));
    }

    public void constructSmarthoneSTAR(Builder builder) {
        builder.setSmartphoneType(SmartphoneType.SMARTPHONE_STAR);
        builder.setColor(new Color("yellow"));
        builder.setName("STAR");
        builder.setNFC(new NFC("3.2"));
        builder.setFingerprintScanner(new FingerprintScanner("10.0"));
    }
}