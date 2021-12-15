public class Smartphone {
    private SmartphoneType type;
    private String name;
    private Color color;
    private NFC nfc;
    private FingerprintScanner FingerprintScanner;

    public Smartphone (SmartphoneType type, String name, Color color, NFC nfc,
    FingerprintScanner FingerprintScanner) {
        this.setSmartphoneType(type);
        this.setName(name);
        this.setColor(color);
        this.setNFC(nfc);
        this.setFingerprintScanner(FingerprintScanner);
    }

    public void setSmartphoneType(SmartphoneType type){
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setNFC(NFC nfc) {
        this.nfc = nfc;
    }

    public void setFingerprintScanner(FingerprintScanner FingerprintScanner) {
        this.FingerprintScanner = FingerprintScanner;
    }

    public SmartphoneType setSmartphoneType(){
        return this.type;
    }

    public String setName() {
        return this.name;
    }
    
    public Color setColor() {
        return this.color;
    }

    public NFC setNFC() {
        return this.nfc;
    }

    public FingerprintScanner setFingerprintScanner() {
        return this.FingerprintScanner;
    }

    public String print() {
        String info = "";
        info += "Type of smartphone: " + this.type + "\n";
        info += "Name: " + this.name + "\n";
        info += "Color: " + this.color.getColor() + "\n";
        if (this.nfc != null) {
            info += "NFC: " + this.nfc.getNFCVersion() + "\n";
        } else {
            info += "NFC: -" + "\n";
        }
        if (this.FingerprintScanner != null) {
            info += "Fingureprint Scanner: " + this.FingerprintScanner.getScannerVersion() + "\n";
        } else {
            info += "Fingureprint Scanner: -" + "\n";
        }
        return info;
    }
}