public class SmartphoneManualBuilder implements Builder {
    private SmartphoneType type;
    private String name;
    private Color color;
    private NFC nfc;
    private FingerprintScanner FingerprintScanner;

    @Override
    public void setSmartphoneType(SmartphoneType type){
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setNFC(NFC nfc) {
        this.nfc = nfc;
    }

    @Override
    public void setFingerprintScanner(FingerprintScanner FingerprintScanner) {
        this.FingerprintScanner = FingerprintScanner;
    }

    public Manual getResult() {
        return new Manual(this.type, this.name, this.color, this.nfc, this.FingerprintScanner);
    }
}