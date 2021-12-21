import java.time.LocalDate;

public class Task1 {

    public static void main(String[] args) {
        Notepad notepad = new Notepad("Mr. Potato");

        notepad.addNote(LocalDate.parse("2021-12-14"), new Notepad.Note("Title1", "Text1"));
        notepad.addNote(LocalDate.parse("2021-12-15"), new Notepad.Note("Title2", "Text2"));
        notepad.addNote(LocalDate.parse("2021-12-14"), new Notepad.Note("Title3", "Text3"));

        for (Notepad.Note note: notepad.getNotesByDate(LocalDate.parse("2021-12-14"))) {
            System.out.println(note);
        }
    }
}
