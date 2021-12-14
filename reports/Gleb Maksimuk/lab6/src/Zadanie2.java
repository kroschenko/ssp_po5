Remote device1 = new RCSecondType(car1);
car1.printCharacteristic();
device1.doorOpening();
device1.engineStart();
device1.doorClosing();
device1.signalingActivation();
}
}
interface Car {
void open();
void close();
void signaling();
void start();
void printCharacteristic();
String getType();
}
class BMWCar implements Car {
private int year;
private int cost;
private String country;
BMWCar(int year1, int cost1, String country1) {
year = year1;
cost = cost1;
country = country1;
}
@Override
public void open() {
System.out.println("BMW car is opened");
}
@Override
public void close() {
System.out.println("BMW car is closed");
}
@Override
public void signaling() {
System.out.println("You activate signaling in BMW car");
}
@Override
public void start() {
System.out.println("BMW car starts to move");
}
@Override
public void printCharacteristic() {
System.out.println("BMW characteristic:");
System.out.println("Year: " + year);
System.out.println("Cost: " + cost + "$");
System.out.println("Country: " + country);
}
@Override
public String getType() {
return "BMW";
}
}
class MercedesCar implements Car {
private int year;
private int cost;
private String country;
MercedesCar(int year1, int cost1, String country1) {
year = year1;
cost = cost1;
country = country1;
}
@Override
public void open() {
System.out.println("Mercedes car is opened");
}
@Override
public void close() {
System.out.println("Mercedes car is closed");
}
@Override
public void signaling() {
System.out.println("You activate signaling in Mercedes car");
}
@Override
public void start() {
System.out.println("Mercedes car starts to move");
}
@Override
public void printCharacteristic() {
System.out.println("Mercedes characteristic:");
System.out.println("Year: " + year);
System.out.println("Cost: " + cost + "$");
System.out.println("Country: " + country);
}
@Override
public String getType() {
return "Mercedes";
}
}
interface Remote {
void signalingActivation();
void doorOpening();
void doorClosing();
void engineStart();
}
class RCFirstType implements Remote {
private Car car;
RCFirstType(Car car) {
this.car = car;
}
@Override
public void signalingActivation() {
System.out.println("Remote control device of first type is going to activate signaling in " + car.getType() + " car");
car.signaling();
}
@Override
public void doorOpening() {
System.out.println("Remote control device of first type is going to open " + car.getType() + " car");
car.open();
}
@Override
public void doorClosing() {
System.out.println("Remote control device of first type is going to close " + car.getType() + " car");
car.close();
}
@Override
public void engineStart() {
System.out.println("Remote control device of first type is going to start engine in " + car.getType() + " car");
car.start();
}
}
class RCSecondType implements Remote {
private Car car;
RCSecondType(Car car) {
this.car = car;
}
@Override
public void signalingActivation() {
System.out.println("Remote control device of second type is going to activate signaling in " + car.getType() + " car");
car.signaling();
}
@Override
public void doorOpening() {
System.out.println("Remote control device of second type is going to open " + car.getType() + " car");
car.open();
}
@Override
public void doorClosing() {
System.out.println("Remote control device of second type is going to close " + car.getType() + " car");
car.close();
}
@Override
public void engineStart() {
System.out.println("Remote control device of second type is going to start engine in " + car.getType() + " car");
car.start();
}
}
