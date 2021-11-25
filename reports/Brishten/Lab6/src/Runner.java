/*
    SINGLETON
    Необходимо, чтобы для класса существовал один экземпляр. То есть паттерн гарантирует существование
    одного объекта для класса, что и демонстрируется в классе-клиенте. 
*/

final class MusikStore {
    private static MusikStore instance;
    public String value;

    private MusikStore(String value) {
        this.value = value;
    }

    public static synchronized MusikStore getInstance(String value) {
        if (instance == null) {
            instance = new MusikStore(value);
        }
        return instance;
    }
}

public class Runner {
    public static void main(String[] args) {
        MusikStore products = MusikStore.getInstance("Folk Tools || Studio || Guitars");
        System.out.println(products.value);
        MusikStore materials = MusikStore.getInstance("Harmony || Drums");
        System.out.println(materials.value);
    }
}
