package com.company;
import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<String> listStrings;
    public Paragraph() {
        this.listStrings = new ArrayList<>();
    }
    public List<String> getListStrings() {
        return listStrings;
    }
    public void addString(String string) {
        listStrings.add(string);
    }
    public void deleteString(int stringNumber) {
        listStrings.remove(stringNumber);
    }
    public void printParagraph() {
        listStrings.forEach(string -> System.out.print(string.concat(" ")));
    }
}
