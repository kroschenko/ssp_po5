package lab;

public class Main {

    public static void main(String[] args) {

        RecordBook book = new RecordBook();
        book.AddExam(1, "Math", "Volkova", 8);
        book.AddExam(2, "PE", "Baranov", 10);
        book.AddExam(3, "OSiSP", "Habib", 10);


        book.show();
    }
}
