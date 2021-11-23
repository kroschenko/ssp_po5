package SSP.Lab3.Task2;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    final static String file = "D:\\SSP\\src\\SSP\\Lab3\\Task2\\input.txt";
    public static void main(String[] args) throws IOException {
        Dictionary eng = new Dictionary(file);
        //добавление элеменов
        eng.add("cute","милый",10);
        eng.add("cute","милый");
        eng.add("house","дом",7);
        eng.add("good","хорошо",9);
        System.out.println("Словарь");
        eng.show();
        System.out.println("Сортировка по количеству обращений");
        eng.showSort();
        System.out.println("Просмотр обоих вариантов словаря\nEnglish - Русский\n");
        eng.show();
        System.out.println("Русский - English\n");
        new Dictionary(eng.reverse()).show();

        System.out.println("Удаление дерево");
        System.out.println("Удаление cute");
        eng.remove("дерево");
        eng.remove("cute");

        System.out.println("Словарь");
        eng.show();
        System.out.println("Поиск read");
        eng.find("read");
        eng.show();

    }

    public static class Dictionary{

        public Dictionary() {
            this.dict = new HashMap<>();
        }
        public Dictionary(String file) throws IOException {
            this.dict = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Pattern pattern =Pattern.compile("^(.+) (.+)$");
            String str = " ";

            while((str = reader.readLine()) != null){
                Matcher matcher = pattern.matcher(str);
                while(matcher.find()){
                    dict.put(new Word(matcher.group(1)), new Word(matcher.group(2)));
                }
            }
        }

        public Dictionary(Map<Word, Word> dict) {
            this.dict = dict;
        }

        Map<Word, Word> dict;
        public void add(String word1, String word2){
            Word temp = new Word(word1);
            if(dict.containsKey(temp)){
                dict.forEach((k,v)->{if (k.equals(temp)) k.count +=1;});
            }
            else {
                dict.put(temp, new Word(word2));
            }
        }
        public void add(String word1, String word2, int count){
            Word temp = new Word(word1, count);
            if(dict.containsKey(temp)){
                dict.forEach((k,v)->{if (k.equals(temp)) k.count +=1;});
            }
            else {
                dict.put(temp, new Word(word2));
            }
        }
        public void remove(String word1){
            dict.entrySet().removeIf((k) -> (k.getKey().word.equals(word1) || k.getValue().word.equals(word1)));
        }
        public void show(){
            for(Map.Entry<Word, Word> entry: dict.entrySet()){
                System.out.println(entry.getKey().word + "    " + entry.getValue().word + " " + entry.getKey().count);
            }
            System.out.println();
        }

        public void showSort(){
            Map<Word, Word> treeDict = new TreeMap<>(dict);
            treeDict.forEach((k,v)-> System.out.println(k.count + "  " + k.word + "   " + v.word));
            System.out.println();
        }

        public Map<Word,Word> reverse(){
            Map<Word, Word> rev = new HashMap<>();
            dict.forEach((k,v)->{rev.put(v,k);});
            return rev;
        }

        public void find(String str){
            dict.forEach((k,v)->{
                if(k.word.equals(str))
                System.out.println("Перевод слова " + str + " - " +v.word);
                k.count++;
            });
        }
    }
    public static class Word implements Comparable<Word>{
        public Word(String word) {
            this.word = word;
            this.count = 0;
        }

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        String word;
        int count;

        @Override
        public int hashCode() {
            int magic =31;
            int res =0;
            res = res*magic + word.hashCode();
            return res;
        }

        @Override
        public boolean equals(Object obj) {
            return this.word.equals(((Word)obj).word);
        }

        @Override
        public int compareTo(Word o) {
            if(this.count == o.count)
                return 0;
            else if (this.count > o.count)
                return 1;
            else
                return -1;
        }
    }
}