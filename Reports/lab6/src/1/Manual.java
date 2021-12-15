public class Manual {
    private SmartphoneType type;
    private String name;
    private Color color;
    private NFC nfc;

    public Smartphone (SmartphoneType type, String name, Color color, NFC nfc,
    FingerprintScanner FingerprintScanner) {
        this.setSmartphoneType(type);
        this.setName(name);
        this.setColor(color);
        this.setNFC(nfc);
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
        return info;
    }
}