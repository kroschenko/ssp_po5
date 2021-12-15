package com.company;

import java.util.*;

public class Lab4Task1 {
    public static void main(String[] args) {
        City test = new City(new String[] {"prospect1", "prospect2", "prospect3"},
                new String[] {"street1", "street2"},
                new String[] {"area1"});

        test.printProspects();

        test.addProspect("prospect4");
        test.removeProspect("prospect1");

        test.printProspects();

        test.setAreas(new String[] {"Red Squar"});

        test.printAreas();
    }
}

class City {
    public class CityChild {
        private ArrayList<String> prospects;
        private ArrayList<String> streets;
        private ArrayList<String> areas;

        public CityChild(String[] prospects, String[] streets, String[] areas) {
            this.prospects = new ArrayList<>(Arrays.asList(prospects));
            this.streets = new ArrayList<>(Arrays.asList(streets));
            this.areas = new ArrayList<>(Arrays.asList(areas));
        }
    }

    private CityChild obj;

    public City(String[] prospects, String[] streets, String[] areas) {
        obj = new CityChild(prospects, streets, areas);
    }

    public void printProspects() {
        int step = 1;

        System.out.println("--------------------------------------");

        for (String prospect : obj.prospects) {
            System.out.println("Проспект #" + step + ": " + prospect);
            step++;
        }

        System.out.println("--------------------------------------\n");
    }

    public void printStreets() {
        int step = 1;

        for (String street : obj.streets) {
            System.out.println("Улица #" + step + ": " + street);
            step++;
        }
    }

    public void printAreas() {
        int step = 1;

        for (String area : obj.areas) {
            System.out.println("Площадь #" + step + ": " + area);
            step++;
        }
    }

    public void addProspect(String prospect) {
        obj.prospects.add(prospect);
    }

    public void addStreet(String street) {
        obj.streets.add(street);
    }

    public void addArea(String area) {
        obj.areas.add(area);
    }

    public void removeProspect(String prospect) {
        obj.prospects.remove(prospect);
    }

    public void removeStreet(String street) {
        obj.streets.remove(street);
    }

    public void removeArea(String area) {
        obj.areas.remove(area);
    }

    public void setProspects(String[] prospects) {
        obj.prospects = new ArrayList<>(Arrays.asList(prospects));
    }

    public void setStreets(String[] streets) {
        obj.streets = new ArrayList<>(Arrays.asList(streets));
    }

    public void setAreas(String[] areas) {
        obj.areas = new ArrayList<>(Arrays.asList(areas));
    }
}