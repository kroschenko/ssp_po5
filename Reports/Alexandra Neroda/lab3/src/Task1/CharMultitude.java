package SSP.Lab3.Task1;

import java.util.*;

public class CharMultitude {
    private int power;
    private List<Character> list = new ArrayList<>();

    public CharMultitude(CharSequence array) {
        for(Character ch : array.toString().toCharArray())
            list.add(ch);
        power = list.size();
        sortArray();
    }

    public CharMultitude(char[] chars) {
        for(char ch : chars)
            list.add(ch);
        power = list.size();
        sortArray();
    }

    public CharMultitude(List<Character> list) {
      for(Character ch : list)
          this.list.add(ch);
        this.power = list.size();
        sortArray();
    }

    private void sortArray(){
        Collections.sort(this.list);
    }

    public void add(char a){
        this.list.add(a);
        this.sortArray();
    }

    public void remove(char a){
        if(this.list.contains((Character)a)){
            int id = list.indexOf((Character)a);
            list.remove(id);
        }
    }
    @Override
    public int hashCode() {
        int hash = 1;
        for (int i = 0; i < power; i++) {
            hash+=31*this.list.get(i);
        }
        return hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharMultitude that = (CharMultitude) o;

        if(getPower() != that.getPower())
            return false;
        int i=0;
        for (; i < getPower(); i++) {
            if(this.list.get(i) != that.list.get(i))
                return false;
        }
        if(i == that.list.size())
            return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for(Character character : this.list)
            stringBuilder.append(" "+character+ " ");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String intersection(CharMultitude a, CharMultitude b){
        Map<Character, Integer> map= new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(Character ch : a.list){
            if(!map.containsKey(ch)) {
                int frequencyA = Collections.frequency(a.list,ch);
                int frequencyB =Collections.frequency(b.list,ch);
                map.put(ch,Math.min(frequencyA,frequencyB));
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }
        return new CharMultitude(list).toString();
    }

    public int getPower() {
        return list.size();
    }
}
