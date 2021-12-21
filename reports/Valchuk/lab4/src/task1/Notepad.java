import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Notepad {
    private String owner;
    private final HashMap<LocalDate, List<Note>> notes = new HashMap<>();

    public Notepad() {}

    public Notepad(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void addNote(LocalDate date, Note note) {
        List<Note> existingNotes = notes.get(date);

        if (existingNotes == null) {
            notes.put(date, new ArrayList<>(List.of(note)));

            return;
        }

        existingNotes.add(note);
    }

    public List<Note> getNotesByDate(LocalDate date) {
        return notes.get(date);
    }

    public static class Note {
        private String title;
        private String text;

        public Note() {}

        public Note(String title, String text) {
            this.title = title;
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public String getText() {
            return text;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format("Note{title=%s, text=%s}", title, text);
        }
    }
}
