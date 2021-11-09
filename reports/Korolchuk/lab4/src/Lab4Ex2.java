package com.spp.labs;

import java.util.*;

public class Lab4Ex2 {
    public static void main(String[] args) {
        Word london_ = new Word("London");
        Word is_ = new Word("is");
        Word a_ = new Word("a");
        Word capital_ = new Word("capital");
        Word of_ = new Word("of");
        Word great_ = new Word("Great");
        Word britain_ = new Word("Britain");
        
        Word he_ = new Word("He");
        Word artyom_ = new Word("Artyom");
        
        Line liacogb__ = new Line(new Word[] {london_, is_, a_, capital_, of_, great_, britain_});
        Line hia__ = new Line(new Word[] {he_, is_, artyom_});
        
        Page liacogb_hia___ = new Page(new Line[] {liacogb__, hia__});
        
        liacogb_hia___.printPage();
    }
}

class Word {
    String word;
    
    public Word(String word) {
        this.word = word;
    }
    
    public void printWord() {
        System.out.println(this.word);
    }
}

class Line {
    String line;
    
    public Line(Word[] words) {
        line = "";
        
        for (Word word : words) {
            line += word.word;
            line += " ";
        }
        
        line = line.trim();
        line += ".";
    }
    
    public void printLine() {
        System.out.println(this.line);
    }
}

class Page {
    String page;
    
    public Page(Line[] lines) {
        page = "";
        
        for (Line line : lines) {
            page += line.line;
            page += "\n";
        }
        
        page = page.trim();
    }
    
    public void printPage() {
        System.out.println(this.page);
    }
}
