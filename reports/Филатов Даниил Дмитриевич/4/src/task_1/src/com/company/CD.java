package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CD {
    private List<Catalog> catalogList;
    public CD() {
        catalogList = new ArrayList<>();
    }
    public Catalog addCatalog(String name) {
        Catalog catalog = new Catalog(name);
        catalog.setSpace("\t");
        catalogList.add(catalog);
        return catalog;
    }
    public void print() {
        catalogList.forEach(System.out::println);
    }
    class Catalog {
        private String name;
        private Catalog catalog;
        private String space;
        public Catalog(String name) {
            this.name = name;
        }
        public void setSpace(String space) {
            this.space = space;
        }
        public Catalog setCatalog(String name) {
            Catalog catalog = new Catalog(name);
            catalog.setSpace(this.space+"\t");
            this.catalog = catalog;
            return catalog;
        }
        @Override
        public String toString() {
            return name + "\n" + space + (Objects.nonNull(catalog) ? catalog : "");
        }
    }
}
