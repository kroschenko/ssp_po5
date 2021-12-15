import java.util.ArrayList;
import java.util.List;

public class task2_lab4 {

    public static void main(String[] args) {
        StarsSystem starSystem = new StarsSystem("Солнечная");

        starSystem.addPlanet(new Planet("Венера", false));
        starSystem.addPlanet(new Planet("Сатурн", false));
        starSystem.addPlanet(new Planet("Венера", false));
        starSystem.addPlanet(new Planet("Меркурий", false));
        starSystem.addPlanet(new Planet("Земля", true));
        starSystem.addPlanet(new Planet("Марс", false));

        starSystem.addStar(new Star("Солнце"));
        starSystem.deletePlanet(5);
        starSystem.printText();
        starSystem.printAlive();
    }
}

class StarsSystem {
    private String name;
    private List<Planet> planetList = new ArrayList<>();
    private List<Star> starList = new ArrayList<>();
    public StarsSystem(String name){
        this.name = name;
    }

    public void addPlanet(Planet planet) {
        planetList.add(planet);
    }

    public void deletePlanet(int planetId) {
        planetList.remove(planetId);
    }

    public void addStar(Star star) {
        starList.add(star);
    }

    public void printAlive(){
        System.out.println("Планеты, населенные жизнью:");
        planetList.stream().filter(Planet::getAlive).forEach(Planet::printPlanet);
    }

    public void deleteStar(int starId) {
        starList.remove(starId);
    }

    public void printText() {
        System.out.println("Система: " + this.name);
        System.out.println("Планеты:" );
        planetList.forEach(Planet::printPlanet);
        System.out.println("Звезды: " );
        starList.forEach(Star::printStar);
    }
}

class Planet {
    private String name;
    private Boolean isAlive;
    public Planet(String name, Boolean isAlive) {
        this.name = name;
        this.isAlive = isAlive;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void printPlanet() {
        System.out.println("\t" + this.name);
    }
}

class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public void printStar() {
        System.out.println("\t" + this.name);
    }
} 