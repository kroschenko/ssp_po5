package SSP.Lab4.SecondTask;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Planet planet = new Planet("Земля");
        planet.add("Евразия",
                "Северная Америка",
                "Южная Америка",
                "Африка",
                "Австралия",
                "Антарктида");
        planet.showInfo();
        System.out.println("\nЗамена - Евразия ");
        planet.changeMainland("Евразия","Брэнт");
        planet.showInfo();
    }
    public static class Planet {
        String name;
        List<Mainland> mainlandList = new ArrayList<>();
        public Planet(String name) {
            this.name = name;
        }
        public void showInfo(){
            System.out.println("Планета: " + this.name);
            mainlandList.forEach((k)->{
                k.showName();
            });
        }
        public void add(String...mainlands){
            for (int i = 0; i < mainlands.length; i++) {
                mainlandList.add(new Mainland(mainlands[i]));
            }
        }
        public void changeMainland(String name, String rename){
            for (int i = 0; i < mainlandList.size(); i++) {
                if(mainlandList.get(i).name.equals(name))
                    mainlandList.get(i).changeName(rename);
            }
        }

        private class Mainland {
            public String name;

            public Mainland(String name) {
                this.name = name;
            }

            public void showName(){
                System.out.println(name);
            }
            public void changeName(String name){
                this.name = name;
            }

        }
    }
}
