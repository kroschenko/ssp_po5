package com.company;
import java.util.ArrayList;

public class IntegerSet {
    private ArrayList<Integer> setOfIntegers;

    public IntegerSet() {
        this.setOfIntegers = new ArrayList();
    }

    public IntegerSet(ArrayList<Integer> setOfIntegers) {
        this.setOfIntegers = new ArrayList<>();
        for(Integer  el: setOfIntegers) {
            if (!this.setOfIntegers.contains(el))
                this.setOfIntegers.add(el);
        }
    }
    public ArrayList<Integer> intersections(IntegerSet set) {
        ArrayList<Integer> list = set.getSetOfIntegers();
        list.retainAll(this.setOfIntegers);
        return list;
    }
    public boolean contains(int item) {
        return this.setOfIntegers.contains(item);
    }
    public int getItemById(int id) {
        --id;
        return (Integer)this.setOfIntegers.get(id);
    }
    public void addItem(int item) {
        this.setOfIntegers.add(item);
    }
    public void deleteItemById(int id) {
        this.setOfIntegers.remove(id);
    }
    public ArrayList<Integer> getSetOfIntegers() {
        return this.setOfIntegers;
    }
    public void setSetOfIntegers(ArrayList<Integer> setOfIntegers) {
        this.setOfIntegers = setOfIntegers;
    }
    public String toString() {
        return "IntegerSet = " + this.setOfIntegers;
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            IntegerSet that = (IntegerSet)o;
            return this.setOfIntegers.equals(that.setOfIntegers);
        } else {
            return false;
        }
    }
}
