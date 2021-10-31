package main5.task2;

public class Main {

    public static void main(String[] args) {
        var orchestra = new MusicalInstrument[]{new PercussionInstrument(), new StringedInstrument(), new WindInstrument()};
        for (var instrument : orchestra) {
            instrument.play();
        }
    }
}
