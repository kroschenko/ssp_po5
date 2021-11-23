package SSP.Lab4.FirstTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Notepad notepad = new Notepad();
        notepad.show();
        notepad.add();
        notepad.add();
        notepad.show();
        notepad.deleteDate();
        notepad.show();
    }

    public static class Notepad{
        List<Date> dates;

        public Notepad() {
            this.dates = new ArrayList<>();
        }

        public class Date{
            List<String> note = new ArrayList<>();
            int dd;
            int mm;
            int year;

            public Date(int dd, int mm, int year) {
                this.dd = dd;
                this.mm = mm;
                this.year = year;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Date date = (Date) o;
                return dd == date.dd &&
                        mm == date.mm &&
                        year == date.year;
            }

            @Override
            public int hashCode() {
                return Objects.hash(dd, mm, year);
            }
        }

        void add() throws IOException {

            Date date = dateInitialization("Добавления");
            String note = noteInitialization();
            Boolean addition = false;
            for (int i = 0; i < this.dates.size() && !addition ; i++) {
                if(date.equals(dates.get(i))) {
                    dates.get(i).note.add(note);
                    addition = true;
                }
            }
            if (!addition){
                date.note.add(note);
                this.dates.add(date);
            }
        }

        public void deleteDate() throws IOException{
            Date delete = dateInitialization("Удаления");
            Iterator<Date> iterator = dates.iterator();
            while(iterator.hasNext()){
                Date date = iterator.next();
                if(delete.equals(date))
                    iterator.remove();
            }
        }

        public void show(){
            for (int i = 0; i < this.dates.size(); i++) {
                System.out.printf("Дата %d/%d/%d\n",dates.get(i).dd,dates.get(i).mm,dates.get(i).year);
                for (int j = 0; j < dates.get(i).note.size(); j++) {
                    System.out.println((j+1)+". "+dates.get(i).note.get(j));
                }
            }
        }

        private Date dateInitialization(String log) throws IOException{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int dd, mm, year;
            System.out.println("Операция : " + log);
            System.out.println("Введите день ");
            dd = Integer.parseInt(reader.readLine());
            System.out.println("Введите месяц ");
            mm = Integer.parseInt(reader.readLine());
            System.out.println("Введите год");
            year = Integer.parseInt(reader.readLine());

            Date date = new Date(dd,mm,year);
            return date;
        }
        private String noteInitialization() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите запись");
            String note = reader.readLine();
            return note;
        }
    }
}
